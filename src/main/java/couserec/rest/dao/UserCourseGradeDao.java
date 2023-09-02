package couserec.rest.dao;

import couserec.rest.entity.Course;
import couserec.rest.entity.User;
import couserec.rest.entity.UserCourseGrade;

public interface UserCourseGradeDao {

    UserCourseGrade getByUserAndCourse(User user, Course course);
}
