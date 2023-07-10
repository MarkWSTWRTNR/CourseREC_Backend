package couserec.rest.dao;

import couserec.rest.entity.Course;

import java.util.List;

public interface CourseDao {
    Course saveCourse(Course course);
    List<Course> saveCourses(List<Course> courses);
    List<Course> getCourses();
    Course getCourseById(int id);

//    Course findByCourseId(Course courseId);

    Course updateCourse(Course course);
}
