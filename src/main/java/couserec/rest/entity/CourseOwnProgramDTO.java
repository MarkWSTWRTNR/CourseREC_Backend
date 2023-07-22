package couserec.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseOwnProgramDTO {
    int id;
    String programId;
    String name;
    String freeElective;
    String curriculumName;
    int creditGerclp;
    int creditGercic;
    int creditGercac;
    int creditGeec;
    int creditFoscc;
    int creditFosmcrc;
    int creditFosme;
    int creditFe;
}
