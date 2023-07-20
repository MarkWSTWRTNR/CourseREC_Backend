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
    int credit;
    String programId;
    String name;
    String freeElective;
    ProgramOwnFacultyDTO faculty;

    //  General Education | Required courses | Learner Person
    @Builder.Default
    List<ProgramOwnCourseDTO> gerclp = new ArrayList<>();
    //   General Education | Required courses | Innovative Co-creator
    @Builder.Default
    List<ProgramOwnCourseDTO> gercic = new ArrayList<>();
    //    General Education | Required courses | Active Citizen
    @Builder.Default
    List<ProgramOwnCourseDTO> gercac = new ArrayList<>();
    //    General Education | Elective courses
    @Builder.Default
    List<ProgramOwnCourseDTO> geec = new ArrayList<>();
    //    Feild of Specialization| Core Courses
    @Builder.Default
    List<ProgramOwnCourseDTO> foscc = new ArrayList<>();
    //    Feild of Specialization | Major Courses | Required Courses
    @Builder.Default
    List<ProgramOwnCourseDTO> fosmcrc = new ArrayList<>();
    //    Feild of Specialization | Major Elective
    @Builder.Default
    List<ProgramOwnCourseDTO> fosme = new ArrayList<>();
}
