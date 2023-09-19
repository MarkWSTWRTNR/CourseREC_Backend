package couserec.rest.service;

import couserec.rest.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface UserService {

    User setUserProgram(String username, Program program);

    List<FinishedGroupCourse> getCompletedCoursesByUsername(String username);

    FinishedGroupCourse saveCompletedCourse(String username, FinishedGroupCourse finishedGroupCourse);

    FinishedGroupCourse updateCompletedCourse(String username, int groupId, FinishedGroupCourse finishedGroupCourse);

    String deleteCompletedCourse(String username, int groupId);

    Comment saveCommentForUser(String username, Comment comment);


    String deleteCommentForUser(String username, int id);

    UserCourseGrade addCourseGrade(String username, String courseId, Grade grade);

    @Transactional
    void removeCourseGrade(String username, String courseId);

    Map<String, Double> calculateGPAAndCredit(String username);
}
