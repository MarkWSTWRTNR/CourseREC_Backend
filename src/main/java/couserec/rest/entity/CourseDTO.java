package couserec.rest.entity;

import jakarta.persistence.ManyToMany;
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
public class CourseDTO {
    int id;
    String courseId;
    String name;
    int credit;
    String gradingtype;
    String description;
    List<Course> prerequisite;
    //  General Education | Required courses | Learner Person
    @Builder.Default
    List<CourseOwnProgramDTO> programGerclp = new ArrayList<>();
    //   General Education | Required courses | Innovative Co-creator
    @Builder.Default
    List<CourseOwnProgramDTO> programGercic = new ArrayList<>();
    //    General Education | Required courses | Active Citizen
    @Builder.Default
    List<CourseOwnProgramDTO> programGercac = new ArrayList<>();
    //    General Education | Elective courses
    @Builder.Default
    List<CourseOwnProgramDTO> programGeec = new ArrayList<>();
    //    Feild of Specialization| Core Courses
    @Builder.Default
    List<CourseOwnProgramDTO> programFoscc = new ArrayList<>();
    //    Feild of Specialization | Major Courses | Required Courses
    @Builder.Default
    List<CourseOwnProgramDTO> programFosmcrc = new ArrayList<>();
    //    Feild of Specialization | Major Elective
    @Builder.Default
    List<CourseOwnProgramDTO> programFosme = new ArrayList<>();
    List<CourseOwnStudentDTO> students;
}
