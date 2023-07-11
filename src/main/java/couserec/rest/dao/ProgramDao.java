package couserec.rest.dao;

import couserec.rest.entity.Program;

import java.util.List;

public interface ProgramDao {
    Program saveProgram(Program program);

    List<Program> getPrograms();

    Program getProgramById(int id);

    Program updateProgram(Program program);

    Program getProgramByProgramId(String programId);

    String deleteProgram(int id);
}
