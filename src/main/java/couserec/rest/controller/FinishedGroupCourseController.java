package couserec.rest.controller;

import couserec.rest.entity.FinishedGroupCourse;
import couserec.rest.entity.GroupCourse;
import couserec.rest.service.FinishedGroupCourseService;
import couserec.rest.service.GroupCourseService;
import couserec.rest.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class FinishedGroupCourseController {
    @Autowired
    private FinishedGroupCourseService finishedGroupCourseService;

    @PostMapping("/saveFinishedGroupCourse")
    public ResponseEntity<?> saveFinishedGroupCourse(@RequestBody FinishedGroupCourse finishedGroupCourse){
        FinishedGroupCourse saveFinishedGroupCourse = finishedGroupCourseService.saveFinishedGroupCourse(finishedGroupCourse);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFinishedGroupCourseDto(saveFinishedGroupCourse));
    }
    @GetMapping("/getFinishedGroupCourse")
    public ResponseEntity<?> getFinishedGroupCourse(){
        List<FinishedGroupCourse> getFinishedGroupCourse =  finishedGroupCourseService.getFinishedGroupCourse();
        return ResponseEntity.ok(LabMapper.INSTANCE.getFinishedGroupCourseDto(getFinishedGroupCourse));
    }
    @PutMapping("/updateFinishedGroupCourse")
    public ResponseEntity<?> updateFinishedGroupCourse(@RequestBody FinishedGroupCourse finishedGroupCourse){
        FinishedGroupCourse updateFinishedGroupCourse = finishedGroupCourseService.updateFinishedGroupCourse(finishedGroupCourse);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFinishedGroupCourseDto(updateFinishedGroupCourse));
    }
//    @PutMapping("/removeCourseFromFinishedGroupCourse")
//    public ResponseEntity<?> removeFinishedGroupCourse(@RequestBody FinishedGroupCourse finishedGroupCourse){
//        FinishedGroupCourse removeCourseFormFinishedGroupCourse = finishedGroupCourseService.removeCourseFromFinishedGroupCourse(finishedGroupCourse);
//        return ResponseEntity.ok(LabMapper.INSTANCE.getFinishedGroupCourseDto(removeCourseFormFinishedGroupCourse));
//    }
    @DeleteMapping("/deleteFinishedGroupCourse/{id}")
    public ResponseEntity<?> deleteFinishedGroupCourse(@PathVariable int id){
        String deleteFinishedGroupCourse = finishedGroupCourseService.deleteFinishedGroupCourse(id);
        return ResponseEntity.ok(deleteFinishedGroupCourse);
    }
    @GetMapping("/calculateAllGroupGPAAndCredit")
    public ResponseEntity<Map<Integer, Map<String, Double>>> calculateAllGroupGPAAndCredit() {
        Map<Integer, Map<String, Double>> results = finishedGroupCourseService.calculateGroupGPAAndCreditForAllGroups();
        return ResponseEntity.ok(results);
    }
    @Autowired
    private GroupCourseService groupCourseService;

    @GetMapping("/{finishedGroupId}/total-credits")
    public ResponseEntity<Map<String, Integer>> calculateTotalCreditsForFinishedGroupCourse(@PathVariable int finishedGroupId) {
        Map<String, Integer> result = finishedGroupCourseService.calculateTotalCreditsForFinishedGroupCourse(finishedGroupId);

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }
}
