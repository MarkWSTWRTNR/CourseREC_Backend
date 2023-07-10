package couserec.rest.service;

import couserec.rest.entity.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    List<Course> saveCourses(List<Course> courses);
    List<Course> getCourses();
    Course getCourseById(int id);



    Course updateCourse(Course course);

//    Course findByCourseId(Course courseId);

//    Course findByName(Course name);
//
//    Course findByDescription(Course description);
}
