package couserec.rest.dao;

import couserec.rest.entity.Student;

import java.util.List;

public interface StudentDao {

    Student saveStudentFinishedCourse(Student student);

    List<Student> getStudentFinishedCourse();
}
