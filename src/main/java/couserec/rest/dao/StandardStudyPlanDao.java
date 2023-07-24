package couserec.rest.dao;

import couserec.rest.entity.StandardStudyPlan;

import java.util.List;

public interface StandardStudyPlanDao {
    StandardStudyPlan saveStandardStudyPlan(StandardStudyPlan standardStudyPlan);

    List<StandardStudyPlan> getStandardStudyPlans();

    StandardStudyPlan getStandardStudyPlanById(int id);

    StandardStudyPlan updateStandardStudyPlan(StandardStudyPlan standardStudyPlan);

    String deleteStandardStudyPlan(int id);
}
