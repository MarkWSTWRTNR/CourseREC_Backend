package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.dao.FinishedGroupCourseDao;
import couserec.rest.dao.UserCourseGradeDao;
import couserec.rest.entity.Course;
import couserec.rest.entity.FinishedGroupCourse;
import couserec.rest.entity.User;
import couserec.rest.entity.UserCourseGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class FinishedGroupCourseServiceImpl implements FinishedGroupCourseService {
    @Autowired
    FinishedGroupCourseDao finishedGroupCourseDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    UserCourseGradeDao userCourseGradeDao;
    @Override
    @Transactional
    public FinishedGroupCourse saveFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse){
        List<Course> existingCourses = new ArrayList<>();
        for (Course course : finishedGroupCourse.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            if (existingCourse != null && !existingCourses.contains(existingCourse)) {
                existingCourses.add(existingCourse);
            }
        }
        finishedGroupCourse.setCourses(existingCourses);
        return finishedGroupCourseDao.saveFinishedGroupCourse(finishedGroupCourse);
    }
    @Override
    public List<FinishedGroupCourse> getFinishedGroupCourse(){
        return finishedGroupCourseDao.getFinishedGroupCourse();
    }

    @Override
    public FinishedGroupCourse updateFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse) {
        FinishedGroupCourse existingFinishedGroupCourse = finishedGroupCourseDao.getFinishedGroupCourseById(finishedGroupCourse.getId());
        if (existingFinishedGroupCourse == null){
            return null;
        }
        existingFinishedGroupCourse.setYear(finishedGroupCourse.getYear());
        existingFinishedGroupCourse.setSemester(finishedGroupCourse.getSemester());

        List<Course> existingCourses = new ArrayList<>();
        for (Course course : finishedGroupCourse.getCourses()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            if (existingCourse != null && !existingCourses.contains(existingCourse)) {
                existingCourses.add(existingCourse);
            }
        }
        existingFinishedGroupCourse.setCourses(existingCourses);

        return finishedGroupCourseDao.updateFinishedGroupCourse(existingFinishedGroupCourse);
    }
//    @Override
//    public FinishedGroupCourse removeCourseFromFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse){
//        FinishedGroupCourse existingFinishedGroupCourse = finishedGroupCourseDao.getFinishedGroupCourseById(finishedGroupCourse.getId());
//        if (existingFinishedGroupCourse == null){
//            return null;
//        }
//        List<Course> courses = existingFinishedGroupCourse.getCourses();
//        courses.removeIf(course -> course.getCourseId().equals(finishedGroupCourse.getCourses().get(0).getCourseId()));
//        existingFinishedGroupCourse.setCourses(courses);
//        return finishedGroupCourseDao.updateFinishedGroupCourse(existingFinishedGroupCourse);
//    }
    @Override
    public String deleteFinishedGroupCourse(int id) {
        return finishedGroupCourseDao.deleteFinishedGroupCourse(id);
    }

    @Override
    public Map<Integer, Map<String, Double>> calculateGroupGPAAndCreditForAllGroups() {
        List<FinishedGroupCourse> finishedGroupCourses = finishedGroupCourseDao.getFinishedGroupCourse();
        Map<Integer, Map<String, Double>> results = new HashMap<>();

        for (FinishedGroupCourse groupCourse : finishedGroupCourses) {
            Map<String, Double> result = calculateGroupGPAAndCredit(groupCourse);
            results.put(groupCourse.getId(), result);
        }

        return results;
    }

    @Override
    public Map<String, Double> calculateGroupGPAAndCredit(FinishedGroupCourse finishedGroupCourse) {
        List<Course> courses = finishedGroupCourse.getCourses();
        List<User> users = finishedGroupCourse.getUsers();

        double weightedGradeSum = 0.0;
        int totalCreditHours = 0;

        for (Course course : courses) {
            for (User user : users) {
                UserCourseGrade userCourseGrade = userCourseGradeDao.getByUserAndCourse(user, course);
                if (userCourseGrade != null) {
                    double courseGrade = userCourseGrade.getGrade().getValue();
                    int creditHours = course.getCredit();
                    weightedGradeSum += courseGrade * creditHours;
                    totalCreditHours += creditHours;
                }
            }
        }

        if (totalCreditHours == 0) {
            // Return an appropriate value when no credit hours are found (e.g., no courses in the group)
            return Collections.emptyMap();
        }

        // Calculate group GPA
        double groupGPA = weightedGradeSum / totalCreditHours;

        // Format group GPA to have two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double formattedGroupGPA = Double.parseDouble(decimalFormat.format(groupGPA));

        Map<String, Double> result = new HashMap<>();
        result.put("groupGPA", formattedGroupGPA);
        result.put("groupEarnedCredit", (double) totalCreditHours);

        return result;
    }
}
