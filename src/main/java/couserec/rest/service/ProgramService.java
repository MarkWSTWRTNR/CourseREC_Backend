package couserec.rest.service;

import couserec.rest.entity.Program;

import java.util.List;

public interface ProgramService {
    Program saveProgram(Program program);

    List<Program> getPrograms();
    Program getProgramById(int id);


    Program updateProgram(Program program);
    String deleteProgram(int id);

    Program getProgramByProgramId(String programId);
}
