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
    private int id;


    @Column(unique = true)
    private String courseId;
    private String name;

    private int credit;

    private String gradingtype;
    private String description;

    @ManyToMany
    @Builder.Default
    List<Course> prerequisite = new ArrayList<>();

    @ManyToMany
    List<Curriculum> curriculum;
}
