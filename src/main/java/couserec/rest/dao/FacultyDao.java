package couserec.rest.dao;

import couserec.rest.entity.Faculty;

import java.util.List;

public interface FacultyDao {
    Faculty saveFaculty(Faculty course);

    List<Faculty> getFacultys();

    Faculty getFacultyById(int id);

    Faculty updateFaculty(Faculty course);

    String deleteFaculty(int id);
}
