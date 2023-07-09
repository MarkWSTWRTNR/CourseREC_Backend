package couserec.rest.service;

import couserec.rest.entity.Faculty;
import couserec.rest.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty saveFaculty(Faculty faculty) {
        Integer facultyId = faculty.getFacultyId();
        Faculty existingFaculty = facultyRepository.findByFacultyId(facultyId);
        if (existingFaculty != null) {
            // Handle duplicate facultyId error, such as throwing an exception
            throw new IllegalArgumentException("A faculty with facultyId " + facultyId + " already exists.");
        }

        return facultyRepository.save(faculty);
    }

    public List<Faculty> saveFacultys(List<Faculty> facultys) {
        return facultyRepository.saveAll(facultys);
    }

    public List<Faculty> getFacultys() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(int id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty getFacultyByFacultyId(Integer facultyId) {
        return facultyRepository.findByFacultyId(facultyId);
    }

    public Faculty getFacultyByName(String name) {
        return facultyRepository.findByName(name);
    }

    public boolean deleteFacultyById(Integer facultyId) {
        Faculty faculty = facultyRepository.findByFacultyId(facultyId);
        if (faculty != null) {
            facultyRepository.delete(faculty);
            return true;
        }
        return false;
    }


    public Faculty updateFaculty(Faculty faculty) {
        Faculty existingFaculty = facultyRepository.findById(faculty.getId()).orElse(null);
        existingFaculty.setFacultyId(faculty.getFacultyId());
        existingFaculty.setName(faculty.getName());


        return facultyRepository.save(existingFaculty);
    }
}
