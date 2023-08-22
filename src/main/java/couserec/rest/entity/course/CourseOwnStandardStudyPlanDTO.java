package couserec.rest.entity.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseOwnStandardStudyPlanDTO {
    int id;
    String text;
    int credit;
    String yearAndSemester;
}
