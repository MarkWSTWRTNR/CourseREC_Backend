package couserec.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    int id;


    @Column(unique = true)
    String courseId;
    String name;

    int credit;

    String gradingtype;
    String description;

    @ManyToMany
    @Builder.Default
    List<Course> prerequisite = new ArrayList<>();

    //  General Education | Required courses | Learner Person
    @ManyToMany(mappedBy = "gerclp")
    @Builder.Default
    List<Program> programGerclp = new ArrayList<>();
    //   General Education | Required courses | Innovative Co-creator
    @ManyToMany(mappedBy = "gercIc")
    @Builder.Default
    List<Program> programGercIc = new ArrayList<>();
    //    General Education | Required courses | Active Citizen
    @Builder.Default
    @ManyToMany(mappedBy = "gercac")
    List<Program> programGercac = new ArrayList<>();
    //    General Education | Elective courses
    @Builder.Default
    @ManyToMany(mappedBy = "geec")
    List<Program> programGeec = new ArrayList<>();
    //    Feild of Specialization| Core Courses
    @Builder.Default
    @ManyToMany(mappedBy = "foscc")
    List<Program> programFoscc = new ArrayList<>();
    //    Feild of Specialization | Major Courses | Required Courses
    @Builder.Default
    @ManyToMany(mappedBy = "fosmcrc")
    List<Program> programFosmcrc = new ArrayList<>();
    //    Feild of Specialization | Major Elective
    @Builder.Default
    @ManyToMany(mappedBy = "fosme")
    List<Program> programFosme = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    List<Student> students ;
}
