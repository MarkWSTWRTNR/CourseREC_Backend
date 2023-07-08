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

    public Course saveCourse(Course course){

        return courseRepository.save(course);
    }
    public List<Course> saveCourses(List<Course> courses){
        return courseRepository.saveAll(courses);
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
    public  Course getCourseById(int id){
        return courseRepository.findById(id).orElse(null);
    }
    public Course getCourseByCourseId(Long courseId){
        return courseRepository.findByCourseId(courseId);
    }
    public Course getCourseByName(String name){
        return courseRepository.findByName(name);
    }
    public Course getCourseByDescription(String description){
        return courseRepository.findByDescription(description);
    }
    public String deleteCourse(int id){
        courseRepository.deleteById(id);
        return "Course removed !!"+id;

    }

    public Course updateCourse(Course course){
        Course existingCourse = courseRepository.findById(course.getId()).orElse(null);
        existingCourse.setCourse_id(course.getCourse_id());
        existingCourse.setName(course.getName());
        existingCourse.setCredit(course.getCredit());
        existingCourse.setGradingtype(course.getGradingtype());
        existingCourse.setDescription(course.getDescription());
        return courseRepository.save(existingCourse);
    }
}
