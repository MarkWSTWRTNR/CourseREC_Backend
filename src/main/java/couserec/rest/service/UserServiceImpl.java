package couserec.rest.service;

import couserec.rest.dao.*;
import couserec.rest.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    GroupCourseDao groupCourseDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private FinishedGroupCourseDao finishedGroupCourseDao;
    @Autowired
    private FinishedGroupCourseService finishedGroupCourseService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private UserCourseGradeDao userCourseGradeDao;
    @Autowired
    private ProgramDao programDao;

    @Transactional // Ensure the method is executed within a transaction
    @Override
    public User setUserProgram(String username, Program program) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            // Check if the program already exists or needs to be created
            Program existingProgram = programDao.getProgramByProgramId(program.getProgramId());
            if (existingProgram == null) {
                return null;
            } else {
                // If the program already exists, you can use it directly
                program = existingProgram;
            }

            // Set the program for the user
            user.setPrograms(program);

            // Save the updated user entity
            userDao.save(user);

            return user;
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<FinishedGroupCourse> getCompletedCoursesByUsername(String username) {
        User user = userDao.getUsername(username).orElse(null);
        if (user != null) {
            return user.getFinishedGroupCourses();
        }
        return null;
    }

    @Override
    public FinishedGroupCourse saveCompletedCourse(String username, FinishedGroupCourse finishedGroupCourse) {
        User user = userDao.getUsername(username).orElse(null);
        if (user != null) {
            FinishedGroupCourse savedCourse = finishedGroupCourseService.saveFinishedGroupCourse(finishedGroupCourse);
            if (!savedCourse.getUsers().contains(user)) {
                user.getFinishedGroupCourses().add(savedCourse);
                savedCourse.getUsers().add(user);
                userDao.save(user);
            }
            return savedCourse;
        }
        return null;
    }

    @Override
    public FinishedGroupCourse updateCompletedCourse(String username, int groupId, FinishedGroupCourse finishedGroupCourse) {
        User user = userDao.getUsername(username).orElse(null);
        if (user != null) {
            FinishedGroupCourse updatedCourse = finishedGroupCourseService.updateFinishedGroupCourse(finishedGroupCourse);
            if (!updatedCourse.getUsers().contains(user)) {
                user.getFinishedGroupCourses().removeIf(course -> course.getId() == groupId);
                user.getFinishedGroupCourses().add(updatedCourse);
                updatedCourse.getUsers().add(user);
                userDao.save(user);
            }
            return updatedCourse;
        }
        return null;
    }

    @Override
    @Transactional
    public String deleteCompletedCourse(String username, int groupId) {
        User user = userDao.getUsername(username).orElse(null);
        if (user != null) {
            FinishedGroupCourse existingCourse = user.getFinishedGroupCourses().stream().filter(course -> course.getId() == groupId).findFirst().orElse(null);
            if (existingCourse != null) {
                // Disassociate all courses and their grades from this group
                for (Course course : existingCourse.getCourses()) {
                    // Get the UserCourseGrade for the specific FinishedGroupCourse
                    UserCourseGrade userCourseGrade = userCourseGradeDao.getByUserAndCourseAndFinishedGroupCourse(user, course, existingCourse);
                    if (userCourseGrade != null) {
                        // Delete the course grade
                        user.getUserCourseGrades().remove(userCourseGrade);
                        course.getUserCourseGrades().remove(userCourseGrade);
                        userCourseGradeDao.deleteUserCourseGrade(userCourseGrade.getId());
                    }
                }
                existingCourse.getCourses().clear(); // Clear the courses from the group

                // Remove the completed course from the user
                user.getFinishedGroupCourses().remove(existingCourse);
                existingCourse.getUsers().remove(user);
                userDao.save(user);

                // Delete the completed course
                return finishedGroupCourseService.deleteFinishedGroupCourse(groupId);
            }
        }
        return null;
    }



    @Transactional
    @Override
    public void removeCourseFromFinishedGroupCourse(String username, int finishedGroupCourseId, String courseId) {
        User user = userDao.getUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Course course = courseDao.getCourseByCourseId(courseId);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }

        FinishedGroupCourse finishedGroupCourse = finishedGroupCourseDao.getFinishedGroupCourseById(finishedGroupCourseId);
        if (finishedGroupCourse == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FinishedGroupCourse not found");
        }

        // Remove the course from FinishedGroupCourse
        finishedGroupCourse.getCourses().remove(course);

        // Remove the grade related to that course
        user.getUserCourseGrades().removeIf(userCourseGrade ->
                userCourseGrade.getCourse().equals(course) &&
                        userCourseGrade.getFinishedGroupCourse().equals(finishedGroupCourse)
        );
    }

    @Override
    public Comment saveCommentForUser(String username, Comment comment) {
        User user = userDao.getUsername(username).orElse(null);
        if (user != null) {
            Course course = comment.getCourse(); // Get the course associated with the comment

            // Check if the user has already commented on this course
            boolean hasCommented = user.getComments().stream().anyMatch(existingComment -> existingComment.getCourse().getCourseId().equals(course.getCourseId()));

            if (!hasCommented) {
                comment.setUser(user); // Associate the comment with the user
                Comment savedComment = commentService.saveComment(comment); // Save the comment
                user.getComments().add(savedComment); // Add the comment to the user's comment list
                userDao.save(user); // Update the user in the database
                return savedComment;
            } else {
                throw new IllegalArgumentException("User has already commented on this course");
            }
        }
        return null;
    }

    @Override
    public String deleteCommentForUser(String username, int id) {
        User user = userDao.getUsername(username).orElse(null);
        if (user != null) {
            Optional<Comment> commentToDelete = user.getComments().stream().filter(c -> c.getId() == id).findFirst();
            if (commentToDelete.isPresent()) {
                user.getComments().remove(commentToDelete.get());
                userDao.save(user);
                commentService.deleteComment(id); // Assuming you have a method in commentService to delete comments by ID
                return "Comment deleted successfully";
            } else {
                return "Comment not found for the user";
            }
        }
        return "User not found";
    }

    @Override
    public List<UserCourseGrade> getAllUserCourseGrade() {
        return userCourseGradeDao.getAllUserCourseGrade();
    }

    @Transactional
    @Override
    public UserCourseGrade addCourseGrade(String username, String courseId, int finishedGroupCourseId, Grade grade) {
        User user = userDao.getUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Course course = courseDao.getCourseByCourseId(courseId);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }

        FinishedGroupCourse finishedGroupCourse = finishedGroupCourseDao.getFinishedGroupCourseById(finishedGroupCourseId);
        if (finishedGroupCourse == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FinishedGroupCourse not found");
        }

        UserCourseGrade existingGrade = userCourseGradeDao.getByUserAndCourseAndFinishedGroupCourse(user, course, finishedGroupCourse);

        if (existingGrade != null) {
            existingGrade.setGrade(grade);
            return existingGrade; // Return the existing grade that was updated
        } else {
            UserCourseGrade userCourseGrade = new UserCourseGrade();
            userCourseGrade.setUser(user);
            userCourseGrade.setCourse(course);
            userCourseGrade.setFinishedGroupCourse(finishedGroupCourse);
            userCourseGrade.setGrade(grade);

            user.getUserCourseGrades().add(userCourseGrade);
            course.getUserCourseGrades().add(userCourseGrade);

            return userCourseGrade; // Return the newly added grade
        }
    }

    @Transactional
    @Override
    public void removeCourseGrade(String username, String courseId, int finishedGroupCourseId) {
        User user = userDao.getUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Course course = courseDao.getCourseByCourseId(courseId);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }

        FinishedGroupCourse finishedGroupCourse = finishedGroupCourseDao.getFinishedGroupCourseById(finishedGroupCourseId);
        if (finishedGroupCourse == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FinishedGroupCourse not found");
        }

        user.getUserCourseGrades().removeIf(userCourseGrade ->
                userCourseGrade.getCourse().equals(course) &&
                        userCourseGrade.getFinishedGroupCourse().equals(finishedGroupCourse)
        );
    }


    @Override
    public Map<String, Double> calculateGPAAndCredit(String username) {
        User user = userDao.getUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        List<FinishedGroupCourse> finishedGroupCourses = finishedGroupCourseDao.getFinishedGroupCourse();

        double weightedGradeSum = 0.0;
        int totalCreditHours = 0;

        for (FinishedGroupCourse groupCourse : finishedGroupCourses) {
            if (groupCourse.getUsers().contains(user)) {
                Map<String, Double> groupResult = finishedGroupCourseService.calculateGroupGPAAndCredit(groupCourse);

                // Extract group GPA and earned credit from the result
                double groupGPA = groupResult.get("groupGPA");
                double groupEarnedCredit = groupResult.get("groupEarnedCredit");

                // Update the weightedGradeSum and totalCreditHours with group data
                weightedGradeSum += groupGPA * groupEarnedCredit;
                totalCreditHours += groupEarnedCredit;
            }
        }

        if (totalCreditHours == 0) {
            // Return an appropriate value when no credit hours are found (e.g., user has no grades)
            return Collections.emptyMap();
        }
        double gpa = weightedGradeSum / totalCreditHours;

        // Format GPA to have two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double formattedGPA = Double.parseDouble(decimalFormat.format(gpa));

        Map<String, Double> result = new HashMap<>();
        result.put("gpa", formattedGPA);
        result.put("earnedCredit", (double) totalCreditHours);

        return result;
    }

    @Override
    public Map<String, String> calculateCourseCreditTracking(String username) {
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            return null;
        }

        Program userProgram = user.getPrograms();
        List<GroupCourse> groupCourses = groupCourseDao.getGroupCourses();
        Map<String, String> courseCreditTracking = new HashMap<>();

        // Use a Set to keep track of processed courses for each FinishedGroupCourse
        Set<String> processedCourses = new HashSet<>();

        for (FinishedGroupCourse finishedGroupCourse : user.getFinishedGroupCourses()) {
            for (Course course : finishedGroupCourse.getCourses()) {
                String courseKey = course.getCourseId();
                if (processedCourses.contains(courseKey)) {
                    continue; // Skip the course if it has already been processed
                }

                boolean courseBelongsToProgram = false;
                for (GroupCourse groupCourse : course.getGroupCourses()) {
                    if (groupCourses.contains(groupCourse) && groupCourse.getPrograms().equals(userProgram)) {
                        courseBelongsToProgram = true;
                        String programName = groupCourse.getPrograms().getName();
                        String groupCourseName = groupCourse.getGroupName();
                        String key = programName + " | " + groupCourseName;

                        String existingCredit = courseCreditTracking.getOrDefault(key, "0 / " + groupCourse.getCredit());
                        String[] parts = existingCredit.split(" / ");
                        int totalCredit = Integer.parseInt(parts[0]) + course.getCredit();
                        courseCreditTracking.put(key, totalCredit + " / " + groupCourse.getCredit() + " minimum credit required");
                    }
                }

                if (!courseBelongsToProgram) {
                    String key = "Free Elective";
                    String existingCredit = courseCreditTracking.getOrDefault(key, "0");
                    int totalCredit = Integer.parseInt(existingCredit) + course.getCredit();
                    courseCreditTracking.put(key, totalCredit + "");
                }

                processedCourses.add(courseKey); // Mark this course instance as processed
            }
        }

        return courseCreditTracking;
    }


    @Override
    public List<Course> getRecommendedCourses(String username) {
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            return Collections.emptyList();
        }

        // Get the list of completed course IDs by the user
        Set<String> completedCourseIds = user.getFinishedGroupCourses().stream().flatMap(finishedGroupCourse -> finishedGroupCourse.getCourses().stream()).map(Course::getCourseId).collect(Collectors.toSet());

        // Create a set to store recommended courses
        Set<Course> recommendedCourses = new HashSet<>();

        // Add courses with F or U grade to the recommended list
        List<UserCourseGrade> userGrades = userCourseGradeDao.getByUser(user);
        Set<String> passedCourses = userGrades.stream().filter(grade -> grade.getGrade() != Grade.F && grade.getGrade() != Grade.U).map(grade -> grade.getCourse().getCourseId()).collect(Collectors.toSet());

        for (UserCourseGrade userCourseGrade : userGrades) {
            if ((userCourseGrade.getGrade() == Grade.F || userCourseGrade.getGrade() == Grade.U) && !passedCourses.contains(userCourseGrade.getCourse().getCourseId())) {
                recommendedCourses.add(userCourseGrade.getCourse());
            }
        }
        // Get the list of available group courses
        List<GroupCourse> availableGroupCourses = groupCourseDao.getGroupCourses();

        // Helper function to recursively check prerequisites
        final Consumer<Course>[] checkPrerequisites = new Consumer[]{null};
        checkPrerequisites[0] = (courseToCheck) -> {
            // Check if the course is completed or already recommended
            if (completedCourseIds.contains(courseToCheck.getCourseId()) || recommendedCourses.contains(courseToCheck)) {
                return;
            }

            // Check prerequisites for the course
            boolean allPrerequisitesMet = true;
            for (Course prerequisite : courseToCheck.getPrerequisite()) {
                List<UserCourseGrade> userCourseGrades = userCourseGradeDao.findByUserAndCourse(user, prerequisite);

                // If no grades found for the course, prerequisites are not met
                if (userCourseGrades.isEmpty()) {
                    allPrerequisitesMet = false;
                    break;
                }

                // For simplicity, let's take the most recent grade. You can modify this logic as needed.
                UserCourseGrade mostRecentGrade = userCourseGrades.get(userCourseGrades.size() - 1);

                if (mostRecentGrade.getGrade() == Grade.F || mostRecentGrade.getGrade() == Grade.U || !completedCourseIds.contains(prerequisite.getCourseId())) {
                    allPrerequisitesMet = false;
                    break;
                }

                // Recursively check prerequisites of prerequisite courses
                checkPrerequisites[0].accept(prerequisite);
            }

            if (allPrerequisitesMet) {
                recommendedCourses.add(courseToCheck);
            }
        };

        // Iterate through available group courses
        for (GroupCourse groupCourse : availableGroupCourses) {
            // Check if the user's program matches the program of the group course
            if (groupCourse.getPrograms().equals(user.getPrograms())) {
                for (Course course : groupCourse.getCourses()) {
                    // Check prerequisites for the course
                    checkPrerequisites[0].accept(course);
                }
            }
        }

        // Convert the set of recommended courses to a list
        List<Course> recommendedCourseList = new ArrayList<>(recommendedCourses);

        // Sort the recommended courses by courseId
        Collections.sort(recommendedCourseList, Comparator.comparing(Course::getId));

        return recommendedCourseList;
    }


}
