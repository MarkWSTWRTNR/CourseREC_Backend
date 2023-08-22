package couserec.rest.entity.standardStudyPlan;

import couserec.rest.entity.groupCourse.GroupCourseOwnCourseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardStudyPlanOwnCourseDTO {
    int id;
    String courseId;
    String name;
    int credit;
    String gradingtype;
    String description;
    List<GroupCourseOwnCourseDTO> prerequisite;
}
