package couserec.rest.dao;

import couserec.rest.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseDao {
    Course saveCourse(Course course);

    List<Course> getCourses();
//    Course getCourseById(int id);

    Course getCourseByCourseId(String courseId);

    Course updateCourse(Course course);

    String deleteCourse(int id);
    Page<Course> getCourses(Integer pageSize, Integer page);

    Page<Course> findByCourseIdContainingOrNameContainingOrDescriptionContaining(String keyword, String keyword1, String keyword2, Pageable pageable);

    Page<Course> findAll(Pageable pageable);
}
