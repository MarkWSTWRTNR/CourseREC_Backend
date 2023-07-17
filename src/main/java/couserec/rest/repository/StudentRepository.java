package couserec.rest.repository;

import couserec.rest.entity.Course;
import couserec.rest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAll();
}
