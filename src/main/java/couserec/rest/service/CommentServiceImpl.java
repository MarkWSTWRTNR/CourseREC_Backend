package couserec.rest.service;

import couserec.rest.dao.CommentDao;
import couserec.rest.dao.CourseDao;
import couserec.rest.entity.Comment;
import couserec.rest.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentDao commentDao;
    @Autowired
    CourseDao courseDao;
    @Override
    public Comment saveComment(Comment comment) {
        Course existingCourse = courseDao.getCourseByCourseId(comment.getCourse().getCourseId());
        if (existingCourse == null) {
            throw new IllegalArgumentException("Course not found");
        }

        comment.setCourse(existingCourse);

        Comment savedComment = commentDao.save(comment);

        existingCourse.getComments().add(savedComment);
        courseDao.saveCourse(existingCourse);

        return savedComment;
    }

    @Override
    public List<Comment> getComments(){
        return commentDao.getComment();
    }
//    @Override
//    public Comment getCommentById(int id){
//        return commentDao.getCommentById(id);
//    }
    @Override
    public String deleteComment(int id){
        return commentDao.deleteComment(id);
    }
}
