package couserec.rest.service;

import couserec.rest.entity.Faculty;
import couserec.rest.entity.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty saveFaculty(Faculty faculty);

    List<Faculty> getFacultys();
    Faculty getFacultyById(int id);
    Faculty findByFacultyId(String facultyId);

    Faculty updateFaculty(Faculty faculty);
    String deleteFaculty(int id);
}
