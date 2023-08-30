package couserec.rest.service;

import couserec.rest.entity.Comment;
import couserec.rest.entity.FinishedGroupCourse;
import couserec.rest.entity.Grade;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    List<FinishedGroupCourse> getCompletedCoursesByUsername(String username);

    FinishedGroupCourse saveCompletedCourse(String username, FinishedGroupCourse finishedGroupCourse);

    FinishedGroupCourse updateCompletedCourse(String username, int groupId, FinishedGroupCourse finishedGroupCourse);

    String deleteCompletedCourse(String username, int groupId);

    Comment saveCommentForUser(String username, Comment comment);


    String deleteCommentForUser(String username, int id);

    void addCourseGrade(String username, String courseId, Grade grade);

    @Transactional
    void removeCourseGrade(String username, String courseId);

    double calculateGPA(String username);
}
