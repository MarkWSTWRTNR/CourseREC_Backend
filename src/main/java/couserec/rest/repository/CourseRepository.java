package couserec.rest.repository;

import couserec.rest.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course getCourseByCourseId(String courseId);

//    Course findByName(Course name);
//
//    Course findByDescription(Course description);

    List<Course> findAll();
}
