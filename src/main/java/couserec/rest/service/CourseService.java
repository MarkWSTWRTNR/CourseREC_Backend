package couserec.rest.service;

import couserec.rest.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course saveCourse(Course course);

    List<Course> getCourses();
//    Course getCourseById(int id);
    Page<Course> getCourses(Integer pageSize, Integer page);

    Course updateCourse(Course course);
    String deleteCourse(int id);

    Course getCourseByCourseId(String courseId);

    Page<Course> searchCourses(String keyword, Integer pageSize, Integer page);

//    Course findByName(Course name);
//
//    Course findByDescription(Course description);
}
