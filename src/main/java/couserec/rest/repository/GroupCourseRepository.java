package couserec.rest.repository;

import couserec.rest.entity.GroupCourse;
import couserec.rest.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupCourseRepository extends JpaRepository<GroupCourse, Integer> {
    List<GroupCourse> findAll();
}
