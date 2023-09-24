package couserec.rest.controller;

import couserec.rest.entity.Course;
import couserec.rest.service.CourseService;
import couserec.rest.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class  CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course addCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCourseDto(addCourse));
    }
    @GetMapping("/courses")
    public ResponseEntity<?> getCourses(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {

        perPage = perPage == null ? 12 : perPage;
        page = page == null ? 1 : page;

        Page<Course> pageOutput = courseService.getCourses(perPage, page);

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getCourseDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }
    @GetMapping("/allCourse")
    public ResponseEntity<?> getCourses(){
        List<Course> getCourse = courseService.getCourses();

        return ResponseEntity.ok(LabMapper.INSTANCE.getCourseDto(getCourse));
    }

    @GetMapping("/courseByCourseId/{courseId}")
    public ResponseEntity<?> getCourseByCourseId(@PathVariable String courseId){
        Course getCourseByCourseId = courseService.getCourseByCourseId(courseId);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCourseDto(getCourseByCourseId));
    }
    @PutMapping("/updateCourse")
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        // Save the update course
        Course updateCourse = courseService.updateCourse(course);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCourseDto(updateCourse));
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        String deleteCourse = courseService.deleteCourse(id);
        return ResponseEntity.ok(deleteCourse);
    }
    @GetMapping("/searchCourses")
    public ResponseEntity<?> searchCourses(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {

        perPage = perPage == null ? 12 : perPage;
        page = page == null ? 1 : page;

        Page<Course> searchResults = courseService.searchCourses(keyword, perPage, page);

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(searchResults.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getCourseDto(searchResults.getContent()), responseHeader, HttpStatus.OK);
    }

}
