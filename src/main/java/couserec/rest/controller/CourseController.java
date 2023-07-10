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
//        String courseId = course.getCourseId();
//        Course existingCourse = courseService.findByCourseId(courseId);
//        if (existingCourse != null) {
//            // Handle duplicate courseId error, such as throwing an exception
//            throw new IllegalArgumentException("A course with courseId " + courseId + " already exists.");
//        }

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
    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }


}
