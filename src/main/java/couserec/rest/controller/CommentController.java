package couserec.rest.controller;

import couserec.rest.entity.Comment;
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

    @PostMapping("/addComment")
    public ResponseEntity<?> addComment(@RequestBody Comment comment){
        Comment addComment = commentService.saveComment(comment);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDto(addComment));
    }
    @GetMapping("/comments")
    public ResponseEntity<?> getComments(){
        List<Comment> getComment = commentService.getComments();
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDto(getComment));
    }
    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable int id){
        String deleteComment = commentService.deleteComment(id);
        return ResponseEntity.ok(deleteComment);
    }
}