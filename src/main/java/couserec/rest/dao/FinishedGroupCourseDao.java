package couserec.rest.dao;

import couserec.rest.entity.FinishedGroupCourse;

import java.util.List;

public interface FinishedGroupCourseDao {

    FinishedGroupCourse saveFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse);

    List<FinishedGroupCourse> getFinishedGroupCourse();

    FinishedGroupCourse updateFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse);

    FinishedGroupCourse getFinishedGroupCourseById(int id);

    String deleteFinishedGroupCourse(int id);
}
