package couserec.rest.entity.faculty;

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
public class FacultyDTO {

    int id;
    String facultyId;
    String name;
    @Builder.Default
    List<FacultyOwnProgramDTO> programs = new ArrayList<>();


}
