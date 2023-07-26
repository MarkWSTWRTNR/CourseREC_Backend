package couserec.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    int id;
    String courseId;
    String name;
    int credit;
    String gradingtype;
    String description;
    List<CourseDTO> prerequisite;
    @Builder.Default
    List<CourseOwnGroupCourseDTO> groupCourses = new ArrayList<>();
    List<CourseOwnFinishedCourseDTO> finishedCourses;
    @Builder.Default
    List<CourseOwnStandardStudyPlanDTO> standardStudyPlans = new ArrayList<>();


}
