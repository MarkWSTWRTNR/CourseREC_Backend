package couserec.rest.service;

import couserec.rest.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudentFinishedCourse(Student student);

    List<Student> getStudentFinishedCourse();
}
