package couserec.rest.dao;

import couserec.rest.entity.StandardStudyPlan;
import couserec.rest.repository.StandardStudyPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("db")
public class StandardStudyPlanDaoImpl implements StandardStudyPlanDao{
    @Autowired
    StandardStudyPlanRepository standardStudyPlanRepository;
    @Override
    public StandardStudyPlan saveStandardStudyPlan(StandardStudyPlan standardStudyPlan) {
        return standardStudyPlanRepository.save(standardStudyPlan);
    }
    @Override
    public List<StandardStudyPlan> getStandardStudyPlans() {
        return standardStudyPlanRepository.findAll();
    }
    @Override
    public StandardStudyPlan getStandardStudyPlanById(int id) {
        return standardStudyPlanRepository.findById(id).orElse(null);
    }
    @Override
    public StandardStudyPlan updateStandardStudyPlan(StandardStudyPlan standardStudyPlan) {
        return standardStudyPlanRepository.save(standardStudyPlan);
    }
    @Override
    public String deleteStandardStudyPlan(int id){
        standardStudyPlanRepository.deleteById(id);
        return "StandardStudyPlan removed !!"+id;
    }
}
