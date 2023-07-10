package couserec.rest.dao;

import couserec.rest.entity.Course;
import couserec.rest.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("db")
public class CourseDaoDbImpl implements CourseDao{
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

//    @Override
//    public Course findByCourseId(Course courseId) {
//        return courseRepository.findByCourseId(String.valueOf(courseId));
//    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }
    public String deleteCourse(int id){
        courseRepository.deleteById(id);
        return "Course removed !!"+id;

    }
}
