package couserec.rest.controller;

import couserec.rest.entity.*;
import couserec.rest.service.UserService;
import couserec.rest.util.LabMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users") // Assuming a base endpoint for users
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}/completedCourses")
    public ResponseEntity<?> getCompletedCoursesForUser(@PathVariable String username) {
        List<FinishedGroupCourse> completedCourses = userService.getCompletedCoursesByUsername(username);

        if (completedCourses != null && !completedCourses.isEmpty()) {
            List<FinishedGroupCourseDTO> completedCoursesDTO = LabMapper.INSTANCE.getFinishedGroupCourseDto(completedCourses);
            return ResponseEntity.ok(completedCoursesDTO);
        }
        return null;
    }

    @PostMapping("/{username}/completedCourses")
    public ResponseEntity<?> saveCompletedCourseForUser(@PathVariable String username, @RequestBody FinishedGroupCourse finishedGroupCourse) {
        FinishedGroupCourse savedCourse = userService.saveCompletedCourse(username, finishedGroupCourse);
        if (savedCourse != null) {
            FinishedGroupCourseDTO savedCourseDTO = LabMapper.INSTANCE.getFinishedGroupCourseDto(savedCourse);
            return ResponseEntity.ok(savedCourseDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{username}/completedCourses/{groupId}")
    public ResponseEntity<?> updateCompletedCourseForUser(@PathVariable String username, @PathVariable int groupId, @RequestBody FinishedGroupCourse finishedGroupCourse) {
        FinishedGroupCourse updatedCourse = userService.updateCompletedCourse(username, groupId, finishedGroupCourse);
        if (updatedCourse != null) {
            FinishedGroupCourseDTO updatedCourseDTO = LabMapper.INSTANCE.getFinishedGroupCourseDto(updatedCourse);
            return ResponseEntity.ok(updatedCourseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{username}/completedCourses/{groupId}")
    public ResponseEntity<?> deleteCompletedCourseForUser(@PathVariable String username, @PathVariable int groupId) {
        String result = userService.deleteCompletedCourse(username, groupId);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{username}/comments")
    public ResponseEntity<?> saveCommentForUser(
            @PathVariable String username,
            @RequestBody Comment comment) {

        Comment savedComment = userService.saveCommentForUser(username, comment);

        if (savedComment != null) {
            CommentDTO savedCommentDTO = LabMapper.INSTANCE.getCommentDto(savedComment);
            return ResponseEntity.ok(savedCommentDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{username}/comments/{id}")
    public ResponseEntity<?> deleteCommentForUser(
            @PathVariable String username,
            @PathVariable int id) {
        String result = userService.deleteCommentForUser(username, id);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{username}/courses/{courseId}/setGrade")
    public ResponseEntity<?> setGradeForCourse(
            @PathVariable String username,
            @PathVariable String courseId,
            @RequestBody GradeRequestBody gradeRequestBody) {

        userService.addCourseGrade(username, courseId, gradeRequestBody.getGrade());
        return ResponseEntity.ok("Grade set successfully.");
    }


    @Data // Create a simple class to wrap the grade in the request body
    private static class GradeRequestBody {
        private Grade grade;
    }

    @DeleteMapping("/{username}/courses/{courseId}/removeGrade")
    public ResponseEntity<?> removeCourseGrade(
            @PathVariable String username,
            @PathVariable String courseId) {

        try {
            userService.removeCourseGrade(username, courseId);
            return ResponseEntity.ok("Course grade removed successfully.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while removing the course grade: " + ex.getMessage());
        }
    }
    @GetMapping("/{username}/calculateGPAAndCredit")
    public ResponseEntity<Map<String, Double>> calculateGPAAndCreditForUser(@PathVariable String username) {
        Map<String, Double> result = userService.calculateGPAAndCredit(username);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
