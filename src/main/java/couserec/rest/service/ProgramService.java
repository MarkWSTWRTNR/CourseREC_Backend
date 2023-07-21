package couserec.rest.service;

import couserec.rest.entity.Course;
import couserec.rest.entity.Program;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProgramService {
    Program saveProgram(Program program);

    List<Program> getPrograms();
    Program getProgramById(int id);


    Program updateProgram(Program program);
    String deleteProgram(int id);

    Program getProgramByProgramId(String programId);

    Program addCourseToProgram(Program program);

    @Transactional
    Program removeCourseFromProgram(String programId, String courseId);
}
