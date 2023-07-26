package couserec.rest.dao;

import couserec.rest.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentDao {
    Comment save(Comment comment);


    List<Comment> getComment();

    Comment getCommentById(int id);

    String deleteComment(int id);
}
