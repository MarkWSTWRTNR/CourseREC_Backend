package couserec.rest.dao;

import couserec.rest.entity.Course;
import couserec.rest.entity.User;
import couserec.rest.entity.UserCourseGrade;
import couserec.rest.repository.UserCourseGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("db")
public class UserCourseGradeDaoImpl implements UserCourseGradeDao {
    @Autowired
    UserCourseGradeRepository userCourseGradeRepository;

    @Override
    public UserCourseGrade getByUserAndCourse(User user, Course course){
        return userCourseGradeRepository.getByUserAndCourse(user,course);
    }

    @Override
    public void deleteUserCourseGrade(Long id) {
        userCourseGradeRepository.deleteById(id);
    }
}
