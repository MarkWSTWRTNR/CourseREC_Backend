package couserec.rest.service;

import couserec.rest.entity.course.Course;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);

    List<Course> getCourses();
//    Course getCourseById(int id);
    Page<Course> getCourses(Integer pageSize, Integer page);

    Course updateCourse(Course course);
    String deleteCourse(int id);

    Course getCourseByCourseId(String courseId);

//    Course findByName(Course name);
//
//    Course findByDescription(Course description);
}
