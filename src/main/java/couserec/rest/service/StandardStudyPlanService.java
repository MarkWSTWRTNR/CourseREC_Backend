package couserec.rest.service;

import couserec.rest.entity.StandardStudyPlan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StandardStudyPlanService {

    @Transactional
    StandardStudyPlan saveStandardStudyPlan(StandardStudyPlan groupCourse);

    List<StandardStudyPlan> getStandardStudyPlans();

    StandardStudyPlan getStandardStudyPlanById(int id);

    @Transactional
    StandardStudyPlan updateStandardStudyPlan(StandardStudyPlan groupCourse);

    @Transactional
    StandardStudyPlan removeCourseFromStandardStudyPlan(StandardStudyPlan groupCourse);

    String deleteStandardStudyPlan(int id);
}
