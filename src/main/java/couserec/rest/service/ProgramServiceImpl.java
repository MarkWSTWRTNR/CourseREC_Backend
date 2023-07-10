package couserec.rest.service;

import couserec.rest.dao.ProgramDao;
import couserec.rest.entity.Program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService{

    @Autowired
    ProgramDao facultyDao;

    public Program saveProgram(Program Program) {
        return facultyDao.saveProgram(Program);
    }


    public List<Program> getPrograms() {
        return facultyDao.getPrograms();
    }

    public Program getProgramById(int id) {
        return facultyDao.getProgramById(id);
    }




    public Program updateProgram(Program Program) {

        return facultyDao.updateProgram(Program);
    }

    @Override
    public String deleteProgram(int id) {
        return facultyDao.deleteProgram(id);
    }
}
