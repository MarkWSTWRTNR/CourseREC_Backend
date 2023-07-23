package couserec.rest.controller;

import couserec.rest.entity.GroupCourse;
import couserec.rest.entity.GroupCourse;
import couserec.rest.service.GroupCourseService;
import couserec.rest.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupCourseController {
    @Autowired
    GroupCourseService groupCourseService;

    @PostMapping("/addGroupCourse")
    public ResponseEntity<?> addGroupCourse(@RequestBody GroupCourse groupCourse){
        GroupCourse addGroupCourse = groupCourseService.saveGroupCourse(groupCourse);
        return ResponseEntity.ok(LabMapper.INSTANCE.getGroupCourseDto(addGroupCourse));
    }
    @GetMapping("/groupCourses")
    public ResponseEntity<?> getGroupCourses(){
        List<GroupCourse> getGroupCourse = groupCourseService.getGroupCourses();
        return ResponseEntity.ok(LabMapper.INSTANCE.getGroupCourseDto(getGroupCourse));
    }
    @PutMapping("/updateGroupCourse")
    public ResponseEntity<?> updateGroupCourse(@RequestBody GroupCourse groupCourse) {
        // Save the update groupCourse
        GroupCourse updateGroupCourse = groupCourseService.updateGroupCourse(groupCourse);
        return ResponseEntity.ok(LabMapper.INSTANCE.getGroupCourseDto(updateGroupCourse));
    }
    @DeleteMapping("/deleteGroupCourse/{id}")
    public ResponseEntity<?> deleteGroupCourse(@PathVariable int id) {
        String deleteGroupCourse = groupCourseService.deleteGroupCourse(id);
        return ResponseEntity.ok(deleteGroupCourse);
    }
}
