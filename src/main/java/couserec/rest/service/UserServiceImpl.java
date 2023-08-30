package couserec.rest.service;

import couserec.rest.dao.UserDao;
import couserec.rest.entity.*;
import couserec.rest.repository.CourseRepository;
import couserec.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private FinishedGroupCourseService finishedGroupCourseService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CourseRepository courseRepository;
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
                user.getFinishedGroupCourses().remove(existingCourse);
                existingCourse.getUsers().remove(user);
                userDao.save(user);
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
    public void addCourseGrade(String username, String courseId, Grade grade) {
        User user = userDao.getUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Course course = courseRepository.getCourseByCourseId(courseId);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }

        UserCourseGrade existingGrade = user.getUserCourseGrades().stream()
                .filter(userCourseGrade -> userCourseGrade.getCourse().equals(course))
                .findFirst()
                .orElse(null);

        if (existingGrade != null) {
            existingGrade.setGrade(grade);
        } else {
            UserCourseGrade userCourseGrade = new UserCourseGrade();
            userCourseGrade.setUser(user);
            userCourseGrade.setCourse(course);
            userCourseGrade.setGrade(grade);

            user.getUserCourseGrades().add(userCourseGrade);
            course.getUserCourseGrades().add(userCourseGrade);
        }
    }

    @Transactional
    @Override
    public void removeCourseGrade(String username, String courseId) {
        User user = userDao.getUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Course course = courseRepository.getCourseByCourseId(courseId);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }

        user.getUserCourseGrades().removeIf(userCourseGrade -> userCourseGrade.getCourse().equals(course));

        // Save the user entity at the appropriate place in your service logic
    }
}
