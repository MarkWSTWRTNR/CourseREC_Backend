package couserec.rest.repository;

import couserec.rest.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findByCourseId(Integer courseId);

    Course findByName(String name);

    Course findByDescription(String description);

}
