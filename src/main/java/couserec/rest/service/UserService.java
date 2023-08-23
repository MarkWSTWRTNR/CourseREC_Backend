package couserec.rest.service;

import couserec.rest.entity.FinishedGroupCourse;

import java.util.List;

public interface UserService {
    List<FinishedGroupCourse> getCompletedCoursesByUsername(String username);
}
