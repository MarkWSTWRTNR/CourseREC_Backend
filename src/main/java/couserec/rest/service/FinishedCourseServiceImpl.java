package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.dao.FinishedCourseDao;
import couserec.rest.entity.Course;
import couserec.rest.entity.FinishedCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinishedCourseServiceImpl implements FinishedCourseService {
    @Autowired
    FinishedCourseDao finishedCourseDao;
    @Autowired
    CourseDao courseDao;
    @Override
    @Transactional
    public FinishedCourse saveStudentFinishedCourse(FinishedCourse finishedCourse){
        List<Course> existingCourses = new ArrayList<>();
        for (Course course : finishedCourse.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            if (existingCourse != null && !existingCourses.contains(existingCourse)) {
                existingCourses.add(existingCourse);
            }
        }
        finishedCourse.setCourses(existingCourses);
        return finishedCourseDao.saveStudentFinishedCourse(finishedCourse);
    }
    @Override
    public List<FinishedCourse> getStudentFinishedCourse(){
        return finishedCourseDao.getStudentFinishedCourse();
    }
    @Override
    public FinishedCourse updateStudentFinishedCourse(FinishedCourse finishedCourse) {
        FinishedCourse existingFinishedCourse = finishedCourseDao.getStudentFinishedCourseById(finishedCourse.getId());
        if (existingFinishedCourse == null){
            return null;
        }
        existingFinishedCourse.setYear(finishedCourse.getYear());
        existingFinishedCourse.setSemester(finishedCourse.getSemester());

        List<Course> existingCourses = new ArrayList<>();
        for (Course course : finishedCourse.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            if (existingCourse != null && !existingCourses.contains(existingCourse)) {
                existingCourses.add(existingCourse);
            }
        }
        existingFinishedCourse.setCourses(existingCourses);

        return finishedCourseDao.updateStudentFinishedCourse(existingFinishedCourse);
    }
    @Override
    public FinishedCourse removeCourseFromFinishedCourse(FinishedCourse finishedCourse){
        FinishedCourse existingFinishedCourse = finishedCourseDao.getStudentFinishedCourseById(finishedCourse.getId());
        if (existingFinishedCourse == null){
            return null;
        }
        List<Course> courses = existingFinishedCourse.getCourses();
        courses.removeIf(course -> course.getCourseId().equals(finishedCourse.getCourses().get(0).getCourseId()));
        existingFinishedCourse.setCourses(courses);
        return finishedCourseDao.updateStudentFinishedCourse(existingFinishedCourse);
    }
    @Override
    public String deleteFinishedCourse(int id) {
        return finishedCourseDao.deleteFinishedCourse(id);
    }
}
