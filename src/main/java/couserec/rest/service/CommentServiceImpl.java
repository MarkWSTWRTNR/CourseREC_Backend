package couserec.rest.service;

import couserec.rest.dao.comment.CommentDao;
import couserec.rest.entity.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentDao commentDao;

    @Override
    public Comment saveComment(Comment comment) {
        return commentDao.save(comment);
    }
    @Override
    public List<Comment> getComments(){
        return commentDao.getComment();
    }
    @Override
    public Comment getCommentById(int id){
        return commentDao.getCommentById(id);
    }
    @Override
    public String deleteComment(int id){
        return commentDao.deleteComment(id);
    }
}
