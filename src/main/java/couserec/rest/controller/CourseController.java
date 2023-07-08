package couserec.rest.controller;

import couserec.rest.entity.Course;
import couserec.rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }
    @PostMapping("/addCourses")
    public List<Course> addCourses(@RequestBody List<Course> courses){
        return courseService.saveCourses(courses);
    }
    @GetMapping("/courses")
    public List<Course> findAllCourses(){
        return courseService.getCourses();
    }
    @GetMapping("/courseById/{id}")
    public Course findCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }
    @GetMapping("/coursesByCourseId/{courseId}")
    public  Course findCourseByCourseId(@PathVariable Long courseId){
        return courseService.getCourseByCourseId(courseId);
    }
    @GetMapping("/coursesByName/{name}")
    public Course findCourseByName(@PathVariable String name){
        return courseService.getCourseByName(name);
    }
    @GetMapping("/coursesByDescription/{description}")
    public Course findCourseByDescription(@PathVariable String description){
        return courseService.getCourseByDescription(description);
    }
    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id){
        return courseService.deleteCourse(id);
    }
    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
