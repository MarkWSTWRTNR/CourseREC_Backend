package couserec.rest.dao;

import couserec.rest.entity.Course;
import couserec.rest.entity.Faculty;
import couserec.rest.entity.Program;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FacultyDao {
    Faculty saveFaculty(Faculty faculty);

    List<Faculty> getFacultys();

    Faculty getFacultyById(int id);

    Faculty updateFaculty(Faculty faculty);

    String deleteFaculty(int id);

    Faculty getFacultyByFacultyId(String facultyId);
}
