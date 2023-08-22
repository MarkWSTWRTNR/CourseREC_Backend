package couserec.rest.entity.faculty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacultyOwnProgramDTO {
    int id;
    String programId;
    String name;

}
