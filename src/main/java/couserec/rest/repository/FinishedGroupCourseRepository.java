package couserec.rest.repository;

import couserec.rest.entity.finishedGroupCourse.FinishedGroupCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinishedGroupCourseRepository extends JpaRepository<FinishedGroupCourse, Integer> {
    List<FinishedGroupCourse> findAll();
}
