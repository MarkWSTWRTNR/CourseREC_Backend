package couserec.rest.service;

import couserec.rest.entity.FinishedCourse;

import java.util.List;

public interface FinishedCourseService {
    FinishedCourse saveStudentFinishedCourse(FinishedCourse finishedCourse);

    List<FinishedCourse> getStudentFinishedCourse();

    FinishedCourse updateStudentFinishedCourse(FinishedCourse finishedCourse);

    FinishedCourse removeCourseFromFinishedCourse(FinishedCourse finishedCourse);

    String deleteFinishedCourse(int id);
}
