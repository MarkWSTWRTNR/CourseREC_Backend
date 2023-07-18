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
    String freeElective;
    ProgramOwnFacultyDTO faculty;
    List<CourseDTO> gerclp = new ArrayList<>();
    List<CourseDTO> gercIc = new ArrayList<>();
}
