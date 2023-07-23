package couserec.rest.repository;

import couserec.rest.entity.FinishedCourse;
import couserec.rest.service.FinishedCourseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinishedCourseRepository extends JpaRepository<FinishedCourse, Integer> {
    List<FinishedCourse> findAll();
}
