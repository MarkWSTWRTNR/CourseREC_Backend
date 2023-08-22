package couserec.rest.service;

import couserec.rest.dao.course.CourseDao;
import couserec.rest.dao.program.ProgramDao;
import couserec.rest.dao.standardStudyPlan.StandardStudyPlanDao;
import couserec.rest.entity.course.Course;
import couserec.rest.entity.standardStudyPlan.StandardStudyPlan;
import couserec.rest.entity.program.Program;
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
    public StandardStudyPlan saveStandardStudyPlan(StandardStudyPlan standardStudyPlan) {
        Program program = programDao.getProgramByProgramId(standardStudyPlan.getPrograms().getProgramId());
        standardStudyPlan.setPrograms(program);

        List<Course> courses = new ArrayList<>();
        for (Course course : standardStudyPlan.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());

            // Check if the course already exists in any of the program's standard study plans
            boolean isDuplicate = false;
            for (StandardStudyPlan existingStudyPlan : program.getStandardStudyPlans()) {
                if (existingStudyPlan.getCourses().contains(existingCourse)) {
                    isDuplicate = true;
                    System.out.println("Course already exists in another standard study plan of Program " + program.getProgramId());
                    break;
                }
            }
            if (!isDuplicate) {
                courses.add(existingCourse);
            }
        }
        standardStudyPlan.setCourses(courses);
        return standardStudyPlanDao.saveStandardStudyPlan(standardStudyPlan);
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
        // Update the list of courses associated with the standard study plan
        List<Course> coursesToAdd = new ArrayList<>();
        for (Course course : groupCourse.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());

            // Check if the course already exists in any standard study plan of the program (excluding the current one being updated)
            boolean isDuplicate = false;
            for (StandardStudyPlan otherStandardStudyPlan : program.getStandardStudyPlans()) {
                if (!otherStandardStudyPlan.equals(existingStandardStudyPlan) && otherStandardStudyPlan.getCourses().contains(existingCourse)) {
                    isDuplicate = true;
                    System.out.println("Course already exists in another standard study plan of Program " + program.getProgramId());
                    break;
                }
            }
            if (!isDuplicate) {
                coursesToAdd.add(existingCourse);
            }
        }
        existingStandardStudyPlan.setCourses(coursesToAdd);
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
