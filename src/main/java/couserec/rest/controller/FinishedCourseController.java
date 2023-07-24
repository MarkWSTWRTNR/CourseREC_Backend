package couserec.rest.controller;

import couserec.rest.entity.FinishedCourse;
import couserec.rest.service.FinishedCourseService;
import couserec.rest.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FinishedCourseController {
    @Autowired
    private FinishedCourseService finishedCourseService;

    @PostMapping("/saveStudentFinishedCourse")
    public ResponseEntity<?> saveFinishedCourse(@RequestBody FinishedCourse finishedCourse){
        FinishedCourse saveFinishedCourse = finishedCourseService.saveStudentFinishedCourse(finishedCourse);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFinishedCourseDto(saveFinishedCourse));
    }
    @GetMapping("/getStudentFinishedCourse")
    public ResponseEntity<?> getFinishedCourse(){
        List<FinishedCourse> getFinishedCourse  =  finishedCourseService.getStudentFinishedCourse();
        return ResponseEntity.ok(LabMapper.INSTANCE.getFinishedCourseDto(getFinishedCourse));
    }
    @PutMapping("/updateStudentFinishedCourse")
    public ResponseEntity<?> updateFinishedCourse(@RequestBody FinishedCourse finishedCourse){
        FinishedCourse updateFinishedCourse = finishedCourseService.updateStudentFinishedCourse(finishedCourse);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFinishedCourseDto(updateFinishedCourse));
    }

    @DeleteMapping("/deleteFinishedCourse/{id}")
    public ResponseEntity<?> deleteFinishedCourse(@PathVariable int id){
        String deleteFinishedCourse = finishedCourseService.deleteFinishedCourse(id);
        return ResponseEntity.ok(deleteFinishedCourse);
    }

}
