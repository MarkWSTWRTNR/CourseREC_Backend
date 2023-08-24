package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.entity.Comment;
import couserec.rest.entity.Course;
import couserec.rest.entity.FinishedGroupCourse;
import couserec.rest.entity.User;
import couserec.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FinishedGroupCourseService finishedGroupCourseService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<FinishedGroupCourse> getCompletedCoursesByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            return user.getFinishedGroupCourses();
        }
        return null;
    }
    @Override
    public FinishedGroupCourse saveCompletedCourse(String username, FinishedGroupCourse finishedGroupCourse) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            FinishedGroupCourse savedCourse = finishedGroupCourseService.saveFinishedGroupCourse(finishedGroupCourse);
            if (!savedCourse.getUsers().contains(user)) {
                user.getFinishedGroupCourses().add(savedCourse);
                savedCourse.getUsers().add(user);
                userRepository.save(user);
            }
            return savedCourse;
        }
        return null;
    }


    @Override
    public FinishedGroupCourse updateCompletedCourse(String username, int groupId, FinishedGroupCourse finishedGroupCourse) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            FinishedGroupCourse updatedCourse = finishedGroupCourseService.updateFinishedGroupCourse(finishedGroupCourse);
            if (!updatedCourse.getUsers().contains(user)) {
                user.getFinishedGroupCourses().removeIf(course -> course.getId() == groupId);
                user.getFinishedGroupCourses().add(updatedCourse);
                updatedCourse.getUsers().add(user);
                userRepository.save(user);
            }
            return updatedCourse;
        }
        return null;
    }

    @Override
    public String deleteCompletedCourse(String username, int groupId) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            FinishedGroupCourse existingCourse = user.getFinishedGroupCourses().stream()
                    .filter(course -> course.getId() == groupId)
                    .findFirst()
                    .orElse(null);
            if (existingCourse != null) {
                user.getFinishedGroupCourses().remove(existingCourse);
                existingCourse.getUsers().remove(user);
                userRepository.save(user);
                return finishedGroupCourseService.deleteFinishedGroupCourse(groupId);
            }
        }
        return null;
    }
    @Override
    public Comment saveCommentForUser(String username, Comment comment) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            comment.setUser(user); // Associate the comment with the user
            Comment savedComment = commentService.saveComment(comment); // Save the comment
            user.getComments().add(savedComment); // Add the comment to the user's comment list
            userRepository.save(user); // Update the user in the database
            return savedComment;
        }
        return null;
    }



    @Override
    public String deleteCommentForUser(String username, int id) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            Optional<Comment> commentToDelete = user.getComments().stream()
                    .filter(c -> c.getId() == id)
                    .findFirst();
            if (commentToDelete.isPresent()) {
                user.getComments().remove(commentToDelete.get());
                userRepository.save(user);
                commentService.deleteComment(id); // Assuming you have a method in commentService to delete comments by ID
                return "Comment deleted successfully";
            } else {
                return "Comment not found for the user";
            }
        }
        return "User not found";
    }
}
