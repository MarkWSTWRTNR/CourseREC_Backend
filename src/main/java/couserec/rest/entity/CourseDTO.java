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
public class CourseDTO {
    int id;
    String courseId;
    String name;
    int credit;
    String gradingtype;
    String description;
    List<CourseDTO> prerequisite;
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
    List<CourseOwnFinishedCourseDTO> finishedCourses;

    @Builder.Default
    List<CourseOwnProgramDTO> Py1s1 = new ArrayList<>();
    @Builder.Default
    List<CourseOwnProgramDTO> Py1s2 = new ArrayList<>();
    @Builder.Default
    List<CourseOwnProgramDTO> Py2s1 = new ArrayList<>();
    @Builder.Default
    List<CourseOwnProgramDTO> Py2s2 = new ArrayList<>();
    @Builder.Default
    List<CourseOwnProgramDTO> Py3s1 = new ArrayList<>();
    @Builder.Default
    List<CourseOwnProgramDTO> Py3s2 = new ArrayList<>();
    @Builder.Default
    List<CourseOwnProgramDTO> Py4s1 = new ArrayList<>();
    @Builder.Default
    List<CourseOwnProgramDTO> Py4s2 = new ArrayList<>();
}
