package couserec.rest.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramDTO {
    int id;
    String programId;
    String name;
    List<ProgramOwnGroupCourseDTO> groupCourses;
    ProgramOwnFacultyDTO faculty;

}
