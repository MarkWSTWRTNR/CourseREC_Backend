package couserec.rest.dao;

import couserec.rest.entity.Comment;
import couserec.rest.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("db")
public class CommentDaoImpl implements CommentDao{
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
    @Override
    public List<Comment> getComment() {
        return commentRepository.findAll();
    }
    @Override
    public Comment getCommentById(int id) {
        return commentRepository.findById(id).orElse(null);
    }
    @Override
    public String deleteComment(int id){
        commentRepository.deleteById(id);
        return "Comment removed !!"+id;

    }
}
