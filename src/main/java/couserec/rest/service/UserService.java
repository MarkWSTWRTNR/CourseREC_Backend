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

    @Transactional
    void removeCourseFromFinishedGroupCourse(String username, int finishedGroupCourseId, String courseId);

    Comment saveCommentForUser(String username, Comment comment);


    String deleteCommentForUser(String username, int id);


    List<UserCourseGrade> getAllUserCourseGrade();

    @Transactional
    UserCourseGrade addCourseGrade(String username, String courseId, int finishedGroupCourseId, Grade grade);

    @Transactional
    void removeCourseGrade(String username, String courseId, int finishedGroupCourseId);

    Map<String, Double> calculateGPAAndCredit(String username);

    User getUserByUsername(String username);

    Map<String, String> calculateCourseCreditTracking(String username);

    List<Course> getRecommendedCourses(String username);
}
