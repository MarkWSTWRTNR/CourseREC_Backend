package couserec.rest.entity;


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
public class ProgramDTO {
    int id;
    String programId;
    String name;
    @Builder.Default
    List<ProgramOwnGroupCourseDTO> groupCourses = new ArrayList<>();
    ProgramOwnFacultyDTO faculty;

}
