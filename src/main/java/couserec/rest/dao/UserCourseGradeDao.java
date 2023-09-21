package couserec.rest.dao;

import couserec.rest.entity.Course;
import couserec.rest.entity.FinishedGroupCourse;
import couserec.rest.entity.User;
import couserec.rest.entity.UserCourseGrade;

import java.util.List;

public interface UserCourseGradeDao {

    UserCourseGrade getByUserAndCourse(User user, Course course);

    void deleteUserCourseGrade(Long id);

    UserCourseGrade getByUserAndCourseAndFinishedGroupCourse(User user, Course course, FinishedGroupCourse finishedGroupCourse);

    List<UserCourseGrade> getByUser(User user);

    List<UserCourseGrade> findByUserAndCourse(User user, Course prerequisite);
}
