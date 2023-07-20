package couserec.rest.service;

import couserec.rest.dao.FacultyDao;
import couserec.rest.entity.Faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    FacultyDao facultyDao;
    @Transactional
    public Faculty saveFaculty(Faculty faculty) {
        return facultyDao.saveFaculty(faculty);
    }


    public List<Faculty> getFacultys() {
        return facultyDao.getFacultys();
    }

    public Faculty getFacultyById(int id) {
        return facultyDao.getFacultyById(id);
    }

    @Override
    public Faculty getFacultyByFacultyId(String facultyId) {
        return facultyDao.getFacultyByFacultyId(facultyId);
    }


    public Faculty updateFaculty(Faculty faculty) {
        Faculty existingFaculty = facultyDao.getFacultyByFacultyId(faculty.getFacultyId());
        if (existingFaculty == null) {
            return null;
        }

        // Update the faculty information
        existingFaculty.setFacultyId(faculty.getFacultyId());
        existingFaculty.setName(faculty.getName());


        return facultyDao.updateFaculty(existingFaculty);
    }

    @Override
    public String deleteFaculty(int id) {
        return facultyDao.deleteFaculty(id);
    }
}
