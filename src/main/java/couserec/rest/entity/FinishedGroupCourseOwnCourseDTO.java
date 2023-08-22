package couserec.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
