package couserec.rest.service;

import couserec.rest.dao.faculty.FacultyDao;
import couserec.rest.dao.program.ProgramDao;
import couserec.rest.entity.faculty.Faculty;
import couserec.rest.entity.program.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    ProgramDao programDao;
    @Autowired
    FacultyDao facultyDao;


    @Transactional
    public Program saveProgram(Program program) {
        Faculty faculty = facultyDao.getFacultyByFacultyId(program.getFaculty().getFacultyId());
        program.setFaculty(faculty);
        faculty.getPrograms().add(program);
        return programDao.saveProgram(program);
    }

    public List<Program> getPrograms() {
        return programDao.getPrograms();
    }

    public Program getProgramById(int id) {
        return programDao.getProgramById(id);
    }

    @Transactional
    public Program updateProgram(Program program) {
        Program existingProgram = programDao.getProgramByProgramId(program.getProgramId());
        if (existingProgram == null) {
            return null;
        }

        // Update the program information
        existingProgram.setProgramId(program.getProgramId());
        existingProgram.setName(program.getName());

        // Update the program's faculty
        Faculty faculty = facultyDao.getFacultyByFacultyId(program.getFaculty().getFacultyId());
        existingProgram.setFaculty(faculty);

        return programDao.updateProgram(existingProgram);
    }

    @Override
    public String deleteProgram(int id) {
        return programDao.deleteProgram(id);
    }

    @Override
    public Program getProgramByProgramId(String programId) {
        return programDao.getProgramByProgramId(programId);
    }


}
