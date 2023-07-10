package couserec.rest.dao;

import couserec.rest.entity.Faculty;

import java.util.List;

public interface FacultyDao {
    Faculty saveFaculty(Faculty faculty);

    List<Faculty> getFacultys();

    Faculty getFacultyById(int id);

    Faculty updateFaculty(Faculty faculty);

    String deleteFaculty(int id);
}
