package couserec.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramOwnStandardStudyPlanDTO {
    int id;
    String text;
    int credit;
    String yearAndSemester;
}
