package couserec.rest.entity.standardStudyPlan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardStudyPlanOwnProgramDTO {
    int id;
    String programId;
    String name;
}
