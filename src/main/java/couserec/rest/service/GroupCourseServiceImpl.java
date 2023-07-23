package couserec.rest.service;

import couserec.rest.dao.GroupCourseDao;
import couserec.rest.dao.ProgramDao;
import couserec.rest.entity.GroupCourse;
import couserec.rest.entity.Program;
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
        Program program = programDao.getProgramByProgramId(groupCourse.getPrograms().getProgramId());
        groupCourse.setPrograms(program);
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
        Program program = programDao.getProgramByProgramId(groupCourse.getPrograms().getProgramId());
        existingGroupCourse.setPrograms(program);
        return groupCourseDao.updateGroupCourse(existingGroupCourse);
    }
    @Override
    public String deleteGroupCourse(int id) {
        return groupCourseDao.deleteGroupCourse(id);
    }
}
