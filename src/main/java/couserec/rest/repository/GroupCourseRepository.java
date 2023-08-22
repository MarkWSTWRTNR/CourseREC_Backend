package couserec.rest.repository;

import couserec.rest.entity.groupCourse.GroupCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupCourseRepository extends JpaRepository<GroupCourse, Integer> {
    List<GroupCourse> findAll();
}
