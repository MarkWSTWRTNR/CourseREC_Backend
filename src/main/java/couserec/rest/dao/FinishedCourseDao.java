package couserec.rest.dao;

import couserec.rest.entity.FinishedCourse;

import java.util.List;

public interface FinishedCourseDao {

    FinishedCourse saveStudentFinishedCourse(FinishedCourse finishedCourse);

    List<FinishedCourse> getStudentFinishedCourse();

    FinishedCourse updateStudentFinishedCourse(FinishedCourse finishedCourse);

    FinishedCourse getStudentFinishedCourseById(int id);

    String deleteFinishedCourse(int id);
}
