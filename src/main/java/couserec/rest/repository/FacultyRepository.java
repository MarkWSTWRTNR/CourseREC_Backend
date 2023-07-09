package couserec.rest.repository;


import couserec.rest.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository  extends JpaRepository<Faculty, Integer> {
    Faculty findByFacultyId(Integer facultyId);

    Faculty findByName(String name);
}
