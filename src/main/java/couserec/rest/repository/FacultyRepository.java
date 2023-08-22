package couserec.rest.repository;


import couserec.rest.entity.faculty.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository  extends JpaRepository<Faculty, Integer> {
    Faculty getFacultyByFacultyId(String FacultyId);
    List<Faculty> findAll();
//    Faculty findByName(String name);
}
