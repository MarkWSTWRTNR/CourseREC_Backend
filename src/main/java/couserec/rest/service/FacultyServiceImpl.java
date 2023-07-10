package couserec.rest.service;

import couserec.rest.dao.FacultyDao;
import couserec.rest.entity.Faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    FacultyDao facultyDao;

    public Faculty saveFaculty(Faculty course) {
        return facultyDao.saveFaculty(course);
    }


    public List<Faculty> getFacultys() {
        return facultyDao.getFacultys();
    }

    public Faculty getFacultyById(int id) {
        return facultyDao.getFacultyById(id);
    }




    public Faculty updateFaculty(Faculty course) {

        return facultyDao.updateFaculty(course);
    }

    @Override
    public String deleteFaculty(int id) {
        return facultyDao.deleteFaculty(id);
    }
}
