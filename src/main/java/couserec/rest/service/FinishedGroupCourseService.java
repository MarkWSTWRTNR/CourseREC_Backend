package couserec.rest.service;

import couserec.rest.entity.finishedGroupCourse.FinishedGroupCourse;

import java.util.List;

public interface FinishedGroupCourseService {
    FinishedGroupCourse saveFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse);

    List<FinishedGroupCourse> getFinishedGroupCourse();



    FinishedGroupCourse updateFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse);

    FinishedGroupCourse removeCourseFromFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse);

    String deleteFinishedGroupCourse(int id);
}
