package couserec.rest.service;

import couserec.rest.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);

    List<Comment> getComments();

//    Comment getCommentById(int id);

    String deleteComment(int id);
}
