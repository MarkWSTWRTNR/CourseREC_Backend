package couserec.rest.controller;

import couserec.rest.entity.FinishedGroupCourse;
import couserec.rest.service.FinishedGroupCourseService;
import couserec.rest.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/removeCourseFromFinishedGroupCourse")
    public ResponseEntity<?> removeFinishedGroupCourse(@RequestBody FinishedGroupCourse finishedGroupCourse){
        FinishedGroupCourse removeCourseFormFinishedGroupCourse = finishedGroupCourseService.removeCourseFromFinishedGroupCourse(finishedGroupCourse);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFinishedGroupCourseDto(removeCourseFormFinishedGroupCourse));
    }
    @DeleteMapping("/deleteFinishedGroupCourse/{id}")
    public ResponseEntity<?> deleteFinishedGroupCourse(@PathVariable int id){
        String deleteFinishedGroupCourse = finishedGroupCourseService.deleteFinishedGroupCourse(id);
        return ResponseEntity.ok(deleteFinishedGroupCourse);
    }

}
