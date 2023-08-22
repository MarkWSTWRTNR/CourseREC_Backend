package couserec.rest.repository;

import couserec.rest.entity.standardStudyPlan.StandardStudyPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StandardStudyPlanRepository extends JpaRepository<StandardStudyPlan, Integer> {
    List<StandardStudyPlan> findAll();
}
