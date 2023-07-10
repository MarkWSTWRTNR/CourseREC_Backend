package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    public Course saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }


    public List<Course> getCourses() {
        return courseDao.getCourses();
    }

    public Course getCourseById(int id) {
        return courseDao.getCourseById(id);
    }




    public Course updateCourse(Course course) {

        return courseDao.updateCourse(course);
    }

    @Override
    public String deleteCourseById(int id) {
        return courseDao.deleteCourse(id);
    }

//    @Override
//    public Course findByCourseId(Course courseId) {
//        return courseDao.findByCourseId(courseId);
//    }
}