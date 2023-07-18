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

    @Column(unique = true)
    String programId;
    String name;
    String freeElective;
    @Column(unique = true)
    String curriculumName;
    //  General Education | Required courses | Learner Person
    @ManyToMany
    @Builder.Default
    List<Course> gerclp = new ArrayList<>();
    //   General Education | Required courses | Innovative Co-creator
//    @ManyToMany(mappedBy = "programList")
//    @Builder.Default
//    List<Course> gercIc = new ArrayList<>();
    @ManyToOne
    Faculty faculty;


//    @OneToOne
//    Curriculum curriculum;
}
