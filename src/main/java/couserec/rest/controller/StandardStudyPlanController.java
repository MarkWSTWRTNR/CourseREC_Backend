package couserec.rest.controller;

import couserec.rest.entity.standardStudyPlan.StandardStudyPlan;
import couserec.rest.service.StandardStudyPlanService;
import couserec.rest.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StandardStudyPlanController {
    @Autowired
    StandardStudyPlanService standardStudyPlanService;

    @PostMapping("/addStandardStudyPlan")
    public ResponseEntity<?> addStandardStudyPlan(@RequestBody StandardStudyPlan standardStudyPlan){
        StandardStudyPlan addStandardStudyPlan = standardStudyPlanService.saveStandardStudyPlan(standardStudyPlan);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStandardStudyPlanDto(addStandardStudyPlan));
    }
    @GetMapping("/standardStudyPlans")
    public ResponseEntity<?> getStandardStudyPlans(){
        List<StandardStudyPlan> getStandardStudyPlan = standardStudyPlanService.getStandardStudyPlans();
        return ResponseEntity.ok(LabMapper.INSTANCE.getStandardStudyPlanDto(getStandardStudyPlan));
    }
    @PutMapping("/updateStandardStudyPlan")
    public ResponseEntity<?> updateStandardStudyPlan(@RequestBody StandardStudyPlan standardStudyPlan) {
        // Save the update standardStudyPlan
        StandardStudyPlan updateStandardStudyPlan = standardStudyPlanService.updateStandardStudyPlan(standardStudyPlan);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStandardStudyPlanDto(updateStandardStudyPlan));
    }
    @PutMapping("/removeCourseFromStandardStudyPlan")
    public ResponseEntity<?> removeCourseFromStandardStudyPlan(@RequestBody StandardStudyPlan standardStudyPlan) {
        StandardStudyPlan removeCourseFromStandardStudyPlan = standardStudyPlanService.removeCourseFromStandardStudyPlan(standardStudyPlan);

        return ResponseEntity.ok(LabMapper.INSTANCE.getStandardStudyPlanDto(removeCourseFromStandardStudyPlan));
    }
    @DeleteMapping("/deleteStandardStudyPlan/{id}")
    public ResponseEntity<?> deleteStandardStudyPlan(@PathVariable int id) {
        String deleteStandardStudyPlan = standardStudyPlanService.deleteStandardStudyPlan(id);
        return ResponseEntity.ok(deleteStandardStudyPlan);
    }
}
