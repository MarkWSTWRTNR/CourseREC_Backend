package couserec.rest.repository;

import couserec.rest.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course getCourseByCourseId(String courseId);
    List<Course> findAll();
    Page<Course> findByCourseIdContainingOrNameContainingOrDescriptionContaining(String courseId, String name, String description, Pageable pageable);

}
