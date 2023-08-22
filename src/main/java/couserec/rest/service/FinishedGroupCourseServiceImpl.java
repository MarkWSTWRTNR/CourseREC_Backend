package couserec.rest.service;

import couserec.rest.dao.course.CourseDao;
import couserec.rest.dao.finishedGroupCourse.FinishedGroupCourseDao;
import couserec.rest.entity.course.Course;
import couserec.rest.entity.finishedGroupCourse.FinishedGroupCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinishedGroupCourseServiceImpl implements FinishedGroupCourseService {
    @Autowired
    FinishedGroupCourseDao finishedGroupCourseDao;
    @Autowired
    CourseDao courseDao;
    @Override
    @Transactional
    public FinishedGroupCourse saveFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse){
        List<Course> existingCourses = new ArrayList<>();
        for (Course course : finishedGroupCourse.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            if (existingCourse != null && !existingCourses.contains(existingCourse)) {
                existingCourses.add(existingCourse);
            }
        }
        finishedGroupCourse.setCourses(existingCourses);
        return finishedGroupCourseDao.saveFinishedGroupCourse(finishedGroupCourse);
    }
    @Override
    public List<FinishedGroupCourse> getFinishedGroupCourse(){
        return finishedGroupCourseDao.getFinishedGroupCourse();
    }

    @Override
    public FinishedGroupCourse updateFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse) {
        FinishedGroupCourse existingFinishedGroupCourse = finishedGroupCourseDao.getFinishedGroupCourseById(finishedGroupCourse.getId());
        if (existingFinishedGroupCourse == null){
            return null;
        }
        existingFinishedGroupCourse.setYear(finishedGroupCourse.getYear());
        existingFinishedGroupCourse.setSemester(finishedGroupCourse.getSemester());

        List<Course> existingCourses = new ArrayList<>();
        for (Course course : finishedGroupCourse.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            if (existingCourse != null && !existingCourses.contains(existingCourse)) {
                existingCourses.add(existingCourse);
            }
        }
        existingFinishedGroupCourse.setCourses(existingCourses);

        return finishedGroupCourseDao.updateFinishedGroupCourse(existingFinishedGroupCourse);
    }
    @Override
    public FinishedGroupCourse removeCourseFromFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse){
        FinishedGroupCourse existingFinishedGroupCourse = finishedGroupCourseDao.getFinishedGroupCourseById(finishedGroupCourse.getId());
        if (existingFinishedGroupCourse == null){
            return null;
        }
        List<Course> courses = existingFinishedGroupCourse.getCourses();
        courses.removeIf(course -> course.getCourseId().equals(finishedGroupCourse.getCourses().get(0).getCourseId()));
        existingFinishedGroupCourse.setCourses(courses);
        return finishedGroupCourseDao.updateFinishedGroupCourse(existingFinishedGroupCourse);
    }
    @Override
    public String deleteFinishedGroupCourse(int id) {
        return finishedGroupCourseDao.deleteFinishedGroupCourse(id);
    }
}
