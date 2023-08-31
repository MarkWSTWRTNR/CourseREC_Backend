package couserec.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseOwnUserCourseGradeDTO {
    private Long id;
    private UserCourseGradeOwnUserDTO user;
    private Grade grade;
}
