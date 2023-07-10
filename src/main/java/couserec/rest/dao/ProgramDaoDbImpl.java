package couserec.rest.dao;


import couserec.rest.entity.Program;
import couserec.rest.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Profile("db")
public class ProgramDaoDbImpl implements ProgramDao {
    @Autowired
    ProgramRepository programRepository;

    @Override
    public Program saveProgram(Program program) {
        return programRepository.save(program);
    }
    @Override
    public List<Program> getPrograms() {
        return programRepository.findAll();
    }
    @Override
    public Program getProgramById(int id) {
        return programRepository.findById(id).orElse(null);
    }
    @Override
    public Program updateProgram(Program program) {
        return programRepository.save(program);
    }
    @Override
    public String deleteProgram(int id){
        programRepository.deleteById(id);
        return "Program removed !!"+id;

    }
}
