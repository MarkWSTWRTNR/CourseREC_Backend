package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.dao.GroupCourseDao;
import couserec.rest.dao.ProgramDao;
import couserec.rest.entity.Course;
import couserec.rest.entity.GroupCourse;
import couserec.rest.entity.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupCourseServiceImpl implements GroupCourseService {
    @Autowired
    GroupCourseDao groupCourseDao;

    @Autowired
    ProgramDao programDao;
    @Autowired
    CourseDao courseDao;

    @Transactional
    @Override
    public GroupCourse saveGroupCourse(GroupCourse groupCourse){
        Program program = programDao.getProgramByProgramId(groupCourse.getPrograms().getProgramId());
        groupCourse.setPrograms(program);

        List<Course> courses = new ArrayList<>();
       for(Course course : groupCourse.getCourses()){
           Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
           if (existingCourse != null && !courses.contains(existingCourse)){
               courses.add(existingCourse);
           }
       }
       groupCourse.setCourses(courses);
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
    @Transactional
    @Override
    public GroupCourse updateGroupCourse(GroupCourse groupCourse) {
        GroupCourse existingGroupCourse = groupCourseDao.getGroupCourseById(groupCourse.getId());
        if (existingGroupCourse == null) {
           return null;
        }
        existingGroupCourse.setGroupName(groupCourse.getGroupName());
        existingGroupCourse.setCredit(groupCourse.getCredit());
        existingGroupCourse.setText(groupCourse.getText());

        Program program = programDao.getProgramByProgramId(groupCourse.getPrograms().getProgramId());
        existingGroupCourse.setPrograms(program);

        // Update the list of courses associated with the group course
        List<Course> courses = new ArrayList<>();
        for (Course course : groupCourse.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            if (existingCourse != null && !courses.contains(existingCourse)) {
                courses.add(existingCourse);
            }
        }
        existingGroupCourse.setCourses(courses);

        return groupCourseDao.updateGroupCourse(existingGroupCourse);
    }
    @Override
    public String deleteGroupCourse(int id) {
        return groupCourseDao.deleteGroupCourse(id);
    }
}