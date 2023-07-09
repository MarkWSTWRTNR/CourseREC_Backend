package couserec.rest.repository;

import couserec.rest.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
    Program findByProgramId(Integer programId);

    Program findByName(String name);
}
