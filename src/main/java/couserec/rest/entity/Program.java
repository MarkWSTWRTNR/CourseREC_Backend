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
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    int id;
    int creditGerclp;
    int creditGercic;
    int creditGercac;
    int creditGeec;
    int creditFoscc;
    int creditFosmcrc;
    int creditFosme;

    @Column(unique = true)
    String programId;
    String name;
    String freeElective;

    //  General Education | Required courses | Learner Person
    @ManyToMany
    @Builder.Default
    List<Course> gerclp = new ArrayList<>();
    //   General Education | Required courses | Innovative Co-creator

    @ManyToMany
    @Builder.Default
    List<Course> gercic = new ArrayList<>();
    //    General Education | Required courses | Active Citizen
    @Builder.Default
    @ManyToMany
    List<Course> gercac = new ArrayList<>();
//    General Education | Elective courses
    @Builder.Default
    @ManyToMany
    List<Course> geec = new ArrayList<>();
//    Feild of Specialization| Core Courses
    @Builder.Default
    @ManyToMany
    List<Course> foscc = new ArrayList<>();
//    Feild of Specialization | Major Courses | Required Courses
    @Builder.Default
    @ManyToMany
    List<Course> fosmcrc = new ArrayList<>();
//    Feild of Specialization | Major Elective
    @Builder.Default
    @ManyToMany
    List<Course> fosme = new ArrayList<>();

    @ManyToOne
    Faculty faculty;


//    @OneToOne
//    Curriculum curriculum;
}
