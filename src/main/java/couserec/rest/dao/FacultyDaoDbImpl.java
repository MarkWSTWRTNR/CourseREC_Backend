package couserec.rest.dao;


import couserec.rest.entity.Faculty;
import couserec.rest.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Profile("db")
public class FacultyDaoDbImpl implements FacultyDao {
    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    @Override
    public List<Faculty> getFacultys() {
        return facultyRepository.findAll();
    }
    @Override
    public Faculty getFacultyById(int id) {
        return facultyRepository.findById(id).orElse(null);
    }
    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    @Override
    public String deleteFaculty(int id){
        facultyRepository.deleteById(id);
        return "Faculty removed !!"+id;

    }

    @Override
    public Faculty getFacultyByFacultyId(String facultyId) {
        return facultyRepository.getFacultyByFacultyId(facultyId);
    }
}
