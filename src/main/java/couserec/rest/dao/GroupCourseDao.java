package couserec.rest.dao;

import couserec.rest.entity.GroupCourse;

import java.util.List;

public interface GroupCourseDao {
    GroupCourse saveGroupCourse(GroupCourse groupCourse);

    List<GroupCourse> getGroupCourses();

    GroupCourse getGroupCourseById(int id);

    GroupCourse updateGroupCourse(GroupCourse groupCourse);

    String deleteGroupCourse(int id);
}
