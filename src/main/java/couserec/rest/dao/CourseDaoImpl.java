package couserec.rest.dao;

import couserec.rest.entity.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class CourseDaoImpl implements CourseDao{
    List<Course> courseList;
    @PostConstruct
    public void init(){
        courseList = new ArrayList<>();
        courseList.add(Course.builder()
                .courseId("953331")
                .name("Compo-based")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("Details").build());
    }

    @Override
    public Course saveCourse(Course course) {
        return course;
    }



    @Override
    public List<Course> getCourses() {
        return courseList;
    }

    @Override
    public Course getCourseById(int id) {
        return courseList.stream()
                .filter(course -> Integer.valueOf(id).equals(course.getId()))
                .findFirst()
                .orElse(null);
    }

//    @Override
//    public Course findByCourseId(Course courseId) {
//        return courseId;
//    }


    @Override
    public Course updateCourse(Course course) {
        return course;
    }

    @Override
    public String deleteCourse(int id) {
        return null;
    }

}
