package couserec.rest.repository;


import couserec.rest.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository  extends JpaRepository<Faculty, Integer> {
//    Faculty findById(int id);
    List<Faculty> findAll();
//    Faculty findByName(String name);
}
