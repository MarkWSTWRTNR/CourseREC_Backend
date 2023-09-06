package couserec.rest.service;

import couserec.rest.entity.FinishedGroupCourse;

import java.util.List;
import java.util.Map;

public interface FinishedGroupCourseService {
    FinishedGroupCourse saveFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse);

    List<FinishedGroupCourse> getFinishedGroupCourse();



    FinishedGroupCourse updateFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse);

//    FinishedGroupCourse removeCourseFromFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse);

    String deleteFinishedGroupCourse(int id);


    Map<Integer, Map<String, Double>> calculateGroupGPAAndCreditForAllGroups();

    Map<String, Double> calculateGroupGPAAndCredit(FinishedGroupCourse finishedGroupCourse);
}
