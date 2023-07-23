package couserec.rest.dao;

import couserec.rest.entity.GroupCourse;
import couserec.rest.repository.GroupCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("db")
public class GroupCourseDaoImpl implements GroupCourseDao{
    @Autowired
    GroupCourseRepository groupCourseRepository;
    @Override
    public GroupCourse saveGroupCourse(GroupCourse groupCourse) {
        return groupCourseRepository.save(groupCourse);
    }
    @Override
    public List<GroupCourse> getGroupCourses() {
        return groupCourseRepository.findAll();
    }
    @Override
    public GroupCourse getGroupCourseById(int id) {
        return groupCourseRepository.findById(id).orElse(null);
    }
    @Override
    public GroupCourse updateGroupCourse(GroupCourse groupCourse) {
        return groupCourseRepository.save(groupCourse);
    }
    @Override
    public String deleteGroupCourse(int id){
        groupCourseRepository.deleteById(id);
        return "GroupCourse removed !!"+id;
    }
}
