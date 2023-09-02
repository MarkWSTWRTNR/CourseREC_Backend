package couserec.rest.repository;

import couserec.rest.entity.Course;
import couserec.rest.entity.User;
import couserec.rest.entity.UserCourseGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCourseGradeRepository extends JpaRepository<UserCourseGrade, Long>{
    UserCourseGrade getByUserAndCourse(User user, Course course);
}
