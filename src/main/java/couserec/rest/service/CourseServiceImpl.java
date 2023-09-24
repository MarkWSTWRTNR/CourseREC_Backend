package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;
    @Transactional
    public Course saveCourse(Course course) {
        List<Course> prerequisites = new ArrayList<>();
        for (Course prerequisite : course.getPrerequisite()) {
            Course fetchedPrerequisite = courseDao.getCourseByCourseId(prerequisite.getCourseId());
            if (fetchedPrerequisite != null) {
                prerequisites.add(fetchedPrerequisite);
            }
        }
        course.setPrerequisite(prerequisites);
        return courseDao.saveCourse(course);
    }




    public List<Course> getCourses() {
        return courseDao.getCourses();
    }

//    public Course getCourseById(int id) {
//        return courseDao.getCourseById(id);
//    }




    public Course updateCourse(Course course) {
        Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
        if (existingCourse == null) {
            return null;
        }

        // Update the course information
        existingCourse.setName(course.getName());
        existingCourse.setCredit(course.getCredit());
        existingCourse.setGradingtype(course.getGradingtype());
        existingCourse.setDescription(course.getDescription());

        // Update the prerequisites
        List<Course> prerequisites = new ArrayList<>();
        for (Course prerequisite : course.getPrerequisite()) {
            Course existingPrerequisite = courseDao.getCourseByCourseId(prerequisite.getCourseId());
            if (existingPrerequisite != null) {
                prerequisites.add(existingPrerequisite);
            }
        }
        existingCourse.setPrerequisite(prerequisites);

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

    @Override
    public Page<Course> getCourses(Integer pageSize, Integer page){
        return courseDao.getCourses(pageSize, page);
    }
    @Override
    public Page<Course> searchCourses(String keyword, Integer pageSize, Integer page) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);

        if (keyword != null && !keyword.isEmpty()) {
            // Implement a custom query using Spring Data JPA to search for courses
            return courseDao.findByCourseIdContainingOrNameContainingOrDescriptionContaining(keyword, keyword, keyword, pageable);
        } else {
            // If no keyword provided, return all courses
            return courseDao.findAll(pageable);
        }
    }

}