package couserec.rest.entity.standardStudyPlan;

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
public class StandardStudyPlanDTO {
    int id;
    String text;
    int credit;
    String yearAndSemester;

    @Builder.Default
    List<StandardStudyPlanOwnCourseDTO> courses = new ArrayList<>();

    StandardStudyPlanOwnProgramDTO programs;
}
