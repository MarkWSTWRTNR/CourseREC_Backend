package couserec.rest.controller;

import couserec.rest.entity.Course;
import couserec.rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody List<Course> course) {
        List<Course> addCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(addCourse);
    }
    @GetMapping("/courses")
    public ResponseEntity<?> getCourses(){
        List<Course> getCourse = courseService.getCourses();
        return ResponseEntity.ok(getCourse);
    }
    @GetMapping("/courseById/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id){
        Course getCourseById = courseService.getCourseById(id);
        return ResponseEntity.ok(getCourseById);
    }
    @GetMapping("/courseByCourseId/{courseId}")
    public ResponseEntity<?> getCourseByCourseId(@PathVariable String courseId){
        Course getCourseByCourseId = courseService.getCourseByCourseId(courseId);
        return ResponseEntity.ok(getCourseByCourseId);
    }
    @PutMapping("/updateCourse")
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        // Save the update course
        Course updateCourse = courseService.updateCourse(course);
        return ResponseEntity.ok(updateCourse);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        String deleteCourse = courseService.deleteCourse(id);
        return ResponseEntity.ok(deleteCourse);
    }

}
