package couserec.rest.controller;

import couserec.rest.entity.Student;
import couserec.rest.service.StudentService;
import couserec.rest.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudentFinishedCourse")
    public ResponseEntity<?> saveFinishedCourse(@RequestBody Student student){
        Student saveFinishedCourse = studentService.saveStudentFinishedCourse(student);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDto(saveFinishedCourse));
    }
    @GetMapping("/getStudentFinishedCourse")
    public ResponseEntity<?> getFinishedCourse(){
        List<Student> getFinishedCourse  =  studentService.getStudentFinishedCourse();
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDto(getFinishedCourse));
    }


}
