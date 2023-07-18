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

    @ManyToMany
    @Builder.Default
    List<Program> programList = new ArrayList<>();
//    @ManyToMany
//    @Builder.Default
//    List<Curriculum> curriculum = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    List<Student> students ;
}
