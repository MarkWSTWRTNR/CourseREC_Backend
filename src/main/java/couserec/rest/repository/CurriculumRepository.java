package couserec.rest.repository;

import couserec.rest.entity.Curriculum;
import couserec.rest.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {
    List<Curriculum> findAll();
}
