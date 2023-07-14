package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    public List<Course> saveCourse(List<Course> courses) {
        List<Course> savedCourses = new ArrayList<>();
        for (Course course : courses) {
            List<Course> prerequisites = new ArrayList<>();
            for (Course prerequisite : course.getPrerequisite()) {
                Course fetchedPrerequisite = courseDao.getCourseByCourseId(prerequisite.getCourseId());
                if (fetchedPrerequisite != null) {
                    prerequisites.add(fetchedPrerequisite);
                }
            }
            course.setPrerequisite(prerequisites);
            savedCourses.add(course);
        }
        return courseDao.saveCourse(savedCourses);
    }



    public List<Course> getCourses() {
        return courseDao.getCourses();
    }

    public Course getCourseById(int id) {
        return courseDao.getCourseById(id);
    }




    public Course updateCourse(Course course) {
        Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
        if (existingCourse == null) {
            return null;
        }
        // Update the course information
        existingCourse.setCourseId(course.getCourseId());
        existingCourse.setName(course.getName());
        existingCourse.setCredit(course.getCredit());
        existingCourse.setGradingtype(course.getGradingtype());
        existingCourse.setDescription(course.getDescription());

        // Update the prerequisites
        existingCourse.setPrerequisite(course.getPrerequisite());

        return courseDao.updateCourse(existingCourse);
    }

    @Override
    public String deleteCourse(int id) {
        return courseDao.deleteCourse(id);
    }

    @Override
    public Course getCourseByCourseId(String courseId) {
        return courseDao.getCourseByCourseId(courseId);
    }
}