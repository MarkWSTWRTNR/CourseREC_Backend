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
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        List<Course> prerequisites = new ArrayList<>();
        for (Course prerequisite : course.getPrerequisite()) {
            Course fetchedPrerequisite = courseService.getCourseById(prerequisite.getId());
            if (fetchedPrerequisite != null) {
                prerequisites.add(fetchedPrerequisite);
            }
        }
        course.setPrerequisite(prerequisites);
        Course addCourse = courseService.saveCourse(course);
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
    @PutMapping("/updateCourse")
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        Course existingCourse = courseService.getCourseById(course.getId());
        if (existingCourse == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the course information
        existingCourse.setCourseId(course.getCourseId());
        existingCourse.setName(course.getName());
        existingCourse.setCredit(course.getCredit());
        existingCourse.setGradingtype(course.getGradingtype());
        existingCourse.setDescription(course.getDescription());

        // Update the prerequisites
        existingCourse.setPrerequisite(course.getPrerequisite());

        // Save the update course
        Course updateCourse = courseService.updateCourse(existingCourse);
        return ResponseEntity.ok(updateCourse);
    }
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        String result = courseService.deleteCourseById(id);
        if (result.equals("Course deleted successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
