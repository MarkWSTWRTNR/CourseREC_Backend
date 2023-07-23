package couserec.rest.service;

import couserec.rest.dao.GroupCourseDao;
import couserec.rest.dao.ProgramDao;
import couserec.rest.entity.GroupCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupCourseServiceImpl implements GroupCourseService {
    @Autowired
    GroupCourseDao groupCourseDao;

    @Autowired
    ProgramDao programDao;

    @Transactional
    @Override
    public GroupCourse saveGroupCourse(GroupCourse groupCourse){
        return groupCourseDao.saveGroupCourse(groupCourse);
    }
    @Override
    public List<GroupCourse> getGroupCourses() {
        return groupCourseDao.getGroupCourses();
    }
    @Override
    public GroupCourse getGroupCourseById(int id) {
        return groupCourseDao.getGroupCourseById(id);
    }
    @Override
    public GroupCourse updateGroupCourse(GroupCourse groupCourse){
        GroupCourse existingGroupCourse = groupCourseDao.getGroupCourseById(groupCourse.getId());
        return groupCourseDao.updateGroupCourse(existingGroupCourse);
    }
    @Override
    public String deleteGroupCourse(int id) {
        return groupCourseDao.deleteGroupCourse(id);
    }
}
