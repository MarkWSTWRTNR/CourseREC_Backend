package couserec.rest.dao;

import couserec.rest.entity.Student;
import couserec.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("db")
public class StudentDaoDbImpl implements StudentDao{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudentFinishedCourse(Student student){
        return studentRepository.save(student);
    }
    @Override
    public List<Student> getStudentFinishedCourse(){
        return studentRepository.findAll();
    }
}
