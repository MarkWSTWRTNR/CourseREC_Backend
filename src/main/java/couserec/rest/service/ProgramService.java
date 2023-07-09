package couserec.rest.service;

import couserec.rest.entity.Program;
import couserec.rest.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    public Program saveProgram(Program program) {
        Integer programId = program.getProgramId();
        Program existingProgram = programRepository.findByProgramId(programId);
        if (existingProgram != null) {
            // Handle duplicate programId error, such as throwing an exception
            throw new IllegalArgumentException("A program with programId " + programId + " already exists.");
        }

        return programRepository.save(program);
    }

    public List<Program> savePrograms(List<Program> programs) {
        return programRepository.saveAll(programs);
    }

    public List<Program> getPrograms() {
        return programRepository.findAll();
    }

    public Program getProgramById(int id) {
        return programRepository.findById(id).orElse(null);
    }

    public Program getProgramByProgramId(Integer programId) {
        return programRepository.findByProgramId(programId);
    }

    public Program getProgramByName(String name) {
        return programRepository.findByName(name);
    }

    public boolean deleteProgramById(Integer programId) {
        Program program = programRepository.findByProgramId(programId);
        if (program != null) {
            programRepository.delete(program);
            return true;
        }
        return false;
    }


    public Program updateProgram(Program program) {
        Program existingProgram = programRepository.findById(program.getId()).orElse(null);
        existingProgram.setProgramId(program.getProgramId());
        existingProgram.setName(program.getName());


        return programRepository.save(existingProgram);
    }

}
