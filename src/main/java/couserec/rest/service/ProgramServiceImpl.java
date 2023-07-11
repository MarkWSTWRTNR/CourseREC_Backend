package couserec.rest.service;

import couserec.rest.dao.ProgramDao;
import couserec.rest.entity.Program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService{

    @Autowired
    ProgramDao programDao;

    public Program saveProgram(Program program) {
        return programDao.saveProgram(program);
    }


    public List<Program> getPrograms() {
        return programDao.getPrograms();
    }

    public Program getProgramById(int id) {
        return programDao.getProgramById(id);
    }




    public Program updateProgram(Program program) {
        Program existingProgram = programDao.getProgramById(program.getId());
        if (existingProgram == null) {
            return null;
        }

        // Update the program information
        existingProgram.setProgramId(program.getProgramId());
        existingProgram.setName(program.getName());
        return programDao.updateProgram(existingProgram);
    }

    @Override
    public String deleteProgram(int id) {
        return programDao.deleteProgram(id);
    }

    @Override
    public Program getProgramByProgramId(String programId){
        return programDao.getProgramByProgramId(programId);
    }
}
