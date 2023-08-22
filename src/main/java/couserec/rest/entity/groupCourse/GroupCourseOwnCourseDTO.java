package couserec.rest.entity.groupCourse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupCourseOwnCourseDTO {
    int id;
    String courseId;
    String name;
    int credit;
    String gradingtype;
    String description;
    List<GroupCourseOwnCourseDTO> prerequisite;
}
