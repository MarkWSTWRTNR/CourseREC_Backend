package couserec.rest.controller;

import couserec.rest.dao.CourseDao;
import couserec.rest.entity.Comment;
import couserec.rest.entity.Course;
import couserec.rest.service.CommentService;
import couserec.rest.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<?> getComments(){
        List<Comment> getComment = commentService.getComments();
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDto(getComment));
    }

}
