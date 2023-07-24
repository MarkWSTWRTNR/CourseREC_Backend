package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.dao.ProgramDao;
import couserec.rest.dao.StandardStudyPlanDao;
import couserec.rest.entity.Course;
import couserec.rest.entity.StandardStudyPlan;
import couserec.rest.entity.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StandardStudyPlanServiceImpl implements StandardStudyPlanService{
    @Autowired
    StandardStudyPlanDao standardStudyPlanDao;
    @Autowired
    ProgramDao programDao;
    @Autowired
    CourseDao courseDao;
    @Transactional
    @Override
    public StandardStudyPlan saveStandardStudyPlan(StandardStudyPlan groupCourse){
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
        return standardStudyPlanDao.saveStandardStudyPlan(groupCourse);
    }
    @Override
    public List<StandardStudyPlan> getStandardStudyPlans() {
        return standardStudyPlanDao.getStandardStudyPlans();
    }
    @Override
    public StandardStudyPlan getStandardStudyPlanById(int id) {
        return standardStudyPlanDao.getStandardStudyPlanById(id);
    }
    @Transactional
    @Override
    public StandardStudyPlan updateStandardStudyPlan(StandardStudyPlan groupCourse) {
        StandardStudyPlan existingStandardStudyPlan = standardStudyPlanDao.getStandardStudyPlanById(groupCourse.getId());
        if (existingStandardStudyPlan == null) {
            return null;
        }
        existingStandardStudyPlan.setYearAndSemester(groupCourse.getYearAndSemester());
        existingStandardStudyPlan.setCredit(groupCourse.getCredit());
        existingStandardStudyPlan.setText(groupCourse.getText());

        Program program = programDao.getProgramByProgramId(groupCourse.getPrograms().getProgramId());
        existingStandardStudyPlan.setPrograms(program);

        // Update the list of courses associated with the group course
        List<Course> courses = new ArrayList<>();
        for (Course course : groupCourse.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            if (existingCourse != null && !courses.contains(existingCourse)) {
                courses.add(existingCourse);
            }
        }
        existingStandardStudyPlan.setCourses(courses);

        return standardStudyPlanDao.updateStandardStudyPlan(existingStandardStudyPlan);
    }
    @Transactional
    @Override
    public StandardStudyPlan removeCourseFromStandardStudyPlan(StandardStudyPlan groupCourse) {
        StandardStudyPlan existingStandardStudyPlan = standardStudyPlanDao.getStandardStudyPlanById(groupCourse.getId());
        if (existingStandardStudyPlan == null) {
            return null;
        }

        // Get the list of courses associated with the group course
        List<Course> courses = existingStandardStudyPlan.getCourses();

        // Find and remove the course to be removed from the list
        courses.removeIf(course -> course.getCourseId().equals(groupCourse.getCourses().get(0).getCourseId()));

        // Update the list of courses associated with the group course
        existingStandardStudyPlan.setCourses(courses);

        return standardStudyPlanDao.updateStandardStudyPlan(existingStandardStudyPlan);
    }

    @Override
    public String deleteStandardStudyPlan(int id) {
        return standardStudyPlanDao.deleteStandardStudyPlan(id);
    }
}
