package couserec.rest.entity.program;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramOwnGroupCourseDTO {
    int id;
    String text;
    int credit;
    String groupName;
}
