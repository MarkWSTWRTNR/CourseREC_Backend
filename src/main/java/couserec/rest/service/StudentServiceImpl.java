package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.dao.StudentDao;
import couserec.rest.entity.Course;
import couserec.rest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentDao studentDao;
    @Autowired
    CourseDao courseDao;
    @Override
    @Transactional
    public Student saveStudentFinishedCourse(Student student){
        List<Course> existingCourses = new ArrayList<>();
        for (Course course : student.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            if (existingCourse != null) {
                existingCourses.add(existingCourse);
            }
        }
        student.setCourses(existingCourses);
        return studentDao.saveStudentFinishedCourse(student);
    }
    @Override
    public List<Student> getStudentFinishedCourse(){
        return studentDao.getStudentFinishedCourse();
    }
}
