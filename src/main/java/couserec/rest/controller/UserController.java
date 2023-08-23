package couserec.rest.controller;

import couserec.rest.entity.FinishedGroupCourse;
import couserec.rest.entity.FinishedGroupCourseDTO;
import couserec.rest.entity.User;
import couserec.rest.service.UserService;
import couserec.rest.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
