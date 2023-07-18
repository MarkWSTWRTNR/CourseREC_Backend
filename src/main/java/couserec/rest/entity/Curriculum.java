package couserec.rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int credit;

    private String freeElective;
    @Column(unique = true)
    private String name;
    String startYear;


//    @ManyToMany(mappedBy = "curriculum")
//    List<Course> courses;
////  General Education | Required courses | Learner Person
    @ManyToMany(mappedBy = "curriculum")
    @Builder.Default
    private List<Course> gerclp = new ArrayList<>();
//    General Education | Required courses | Innovative Co-creator
    @Builder.Default
    @ManyToMany(mappedBy = "curriculum")
    private List<Course> gercIc = new ArrayList<>();
//    General Education | Required courses | Active Citizen
    @Builder.Default
    @ManyToMany(mappedBy = "curriculum")
    private List<Course> gercac = new ArrayList<>();
//    General Education | Elective courses
    @Builder.Default
    @ManyToMany(mappedBy = "curriculum")
    private List<Course> geec = new ArrayList<>();
//    Feild of Specialization| Core Courses
    @Builder.Default
    @ManyToMany(mappedBy = "curriculum")
    private List<Course> foscc = new ArrayList<>();
//    Feild of Specialization | Major Courses | Required Courses
    @Builder.Default
    @ManyToMany(mappedBy = "curriculum")
    private List<Course> fosmcrc = new ArrayList<>();
//    Feild of Specialization | Major Elective
    @Builder.Default
    @ManyToMany(mappedBy = "curriculum")
    private List<Course> fosme = new ArrayList<>();


    @OneToOne
    Program program;
}
