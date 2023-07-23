package couserec.rest.service;

import couserec.rest.entity.GroupCourse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GroupCourseService {
    @Transactional
    GroupCourse saveGroupCourse(GroupCourse groupCourse);

    List<GroupCourse> getGroupCourses();

    GroupCourse getGroupCourseById(int id);

    GroupCourse updateGroupCourse(GroupCourse groupCourse);

    String deleteGroupCourse(int id);
}
