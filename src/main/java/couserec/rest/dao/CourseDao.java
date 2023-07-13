package couserec.rest.dao;

import couserec.rest.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> saveCourse(List<Course> course);

    List<Course> getCourses();
    Course getCourseById(int id);

    Course getCourseByCourseId(String courseId);

    Course updateCourse(Course course);

    String deleteCourse(int id);
}
