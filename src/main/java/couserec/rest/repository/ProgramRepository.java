package couserec.rest.repository;

import couserec.rest.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
//    Program findByProgramId(Integer programId);
//    Program findByName(String name);
    List<Program> findAll();

    Program getProgramByProgramId(String programId);
}
