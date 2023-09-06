package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.dao.FinishedGroupCourseDao;
import couserec.rest.dao.UserCourseGradeDao;
import couserec.rest.dao.UserDao;
import couserec.rest.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

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
    public String deleteCompletedCourse(String username, int groupId) {
        User user = userDao.getUsername(username).orElse(null);
        if (user != null) {
            FinishedGroupCourse existingCourse = user.getFinishedGroupCourses().stream()
                    .filter(course -> course.getId() == groupId)
                    .findFirst()
                    .orElse(null);
            if (existingCourse != null) {
                // Remove associated course grades from users
                for (Course course : existingCourse.getCourses()) {
                    UserCourseGrade userCourseGrade = userCourseGradeDao.getByUserAndCourse(user, course);
                    if (userCourseGrade != null) {
                        // Delete the course grade
                        user.getUserCourseGrades().remove(userCourseGrade);
                        course.getUserCourseGrades().remove(userCourseGrade);
                        userCourseGradeDao.deleteUserCourseGrade(userCourseGrade.getId());
                    }
                }

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
    @Override
    public Comment saveCommentForUser(String username, Comment comment) {
        User user = userDao.getUsername(username).orElse(null);
        if (user != null) {
            comment.setUser(user); // Associate the comment with the user
            Comment savedComment = commentService.saveComment(comment); // Save the comment
            user.getComments().add(savedComment); // Add the comment to the user's comment list
            userDao.save(user); // Update the user in the database
            return savedComment;
        }
        return null;
    }



    @Override
    public String deleteCommentForUser(String username, int id) {
        User user = userDao.getUsername(username).orElse(null);
        if (user != null) {
            Optional<Comment> commentToDelete = user.getComments().stream()
                    .filter(c -> c.getId() == id)
                    .findFirst();
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

    @Transactional
    @Override
    public UserCourseGrade addCourseGrade(String username, String courseId, Grade grade) {
        User user = userDao.getUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Course course = courseDao.getCourseByCourseId(courseId);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }

        UserCourseGrade existingGrade = user.getUserCourseGrades().stream()
                .filter(userCourseGrade -> userCourseGrade.getCourse().equals(course))
                .findFirst()
                .orElse(null);

        if (existingGrade != null) {
            existingGrade.setGrade(grade);
            return existingGrade; // Return the existing grade that was updated
        } else {
            UserCourseGrade userCourseGrade = new UserCourseGrade();
            userCourseGrade.setUser(user);
            userCourseGrade.setCourse(course);
            userCourseGrade.setGrade(grade);

            user.getUserCourseGrades().add(userCourseGrade);
            course.getUserCourseGrades().add(userCourseGrade);

            return userCourseGrade; // Return the newly added grade
        }
    }

    @Transactional
    @Override
    public void removeCourseGrade(String username, String courseId) {
        User user = userDao.getUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Course course = courseDao.getCourseByCourseId(courseId);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }

        user.getUserCourseGrades().removeIf(userCourseGrade -> userCourseGrade.getCourse().equals(course));

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

        Map<String, Double> result = new HashMap<>();
        result.put("gpa", gpa);
        result.put("earnedCredit", (double) totalCreditHours);

        return result;
    }

}
