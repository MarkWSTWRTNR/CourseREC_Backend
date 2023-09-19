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
public class FinishedGroupCourseOwnCourseDTO {
    int id;
    String courseId;
    String name;
    int credit;
    String gradingtype;
    String description;
    @Builder.Default
    List<CourseOwnUserCourseGradeDTO> userCourseGrades = new ArrayList<>();
    @Builder.Default
    List<CourseOwnGroupCourseDTO> groupCourses = new ArrayList<>();
}
