package couserec.rest.service;

import couserec.rest.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course saveCourse(Course course);

    List<Course> getCourses();
    Course getCourseById(int id);


    Course updateCourse(Course course);

    String deleteCourseById(int id);

//    Course findByCourseId(Course courseId);

//    Course findByName(Course name);
//
//    Course findByDescription(Course description);
}
