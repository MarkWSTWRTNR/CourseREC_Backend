package couserec.rest.service;

import couserec.rest.entity.Course;
import couserec.rest.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        Integer courseId = course.getCourseId();
        Course existingCourse = courseRepository.findByCourseId(courseId);
        if (existingCourse != null) {
            // Handle duplicate courseId error, such as throwing an exception
            throw new IllegalArgumentException("A course with courseId " + courseId + " already exists.");
        }

        return courseRepository.save(course);
    }

    public List<Course> saveCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course getCourseByCourseId(Integer courseId) {
        return courseRepository.findByCourseId(courseId);
    }

    public Course getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    public Course getCourseByDescription(String description) {
        return courseRepository.findByDescription(description);
    }

    public boolean deleteCourseById(Integer courseId) {
        Course course = courseRepository.findByCourseId(courseId);
        if (course != null) {
            courseRepository.delete(course);
            return true;
        }
        return false;
    }


    public Course updateCourse(Course course) {
        Course existingCourse = courseRepository.findById(course.getId()).orElse(null);
        existingCourse.setCourseId(course.getCourseId());
        existingCourse.setName(course.getName());
        existingCourse.setCredit(course.getCredit());
        existingCourse.setGradingtype(course.getGradingtype());
        existingCourse.setDescription(course.getDescription());
//        existingCourse.setPrerequisites(course.getPrerequisites());
        // Update prerequisites

        return courseRepository.save(existingCourse);
    }
}
