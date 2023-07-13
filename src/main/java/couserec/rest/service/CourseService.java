package couserec.rest.service;

import couserec.rest.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> saveCourse(List<Course> course);

    List<Course> getCourses();
    Course getCourseById(int id);


    Course updateCourse(Course course);
    String deleteCourse(int id);

    Course getCourseByCourseId(String courseId);

//    Course findByName(Course name);
//
//    Course findByDescription(Course description);
}
