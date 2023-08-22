package couserec.rest.entity.course;

import couserec.rest.entity.groupCourse.GroupCourseOwnProgramDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseOwnGroupCourseDTO {
    int id;
    String text;
    int credit;
    String groupName;
    GroupCourseOwnProgramDTO programs;
}
