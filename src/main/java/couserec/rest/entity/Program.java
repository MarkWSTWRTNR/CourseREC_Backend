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

    @OneToMany(mappedBy = "programs")
            @Builder.Default
    List<GroupCourse> groupCourses = new ArrayList<>();
    @ManyToOne
    Faculty faculty;


//    @OneToOne
//    Curriculum curriculum;
}
