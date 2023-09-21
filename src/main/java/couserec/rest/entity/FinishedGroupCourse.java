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
public class FinishedGroupCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    int id;
    String year;
    String semester;

    @ManyToMany
            @Builder.Default
    List<Course> courses =new ArrayList<>();
    @ManyToMany
    @Builder.Default
    List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "finishedGroupCourse")
    @Builder.Default
    List<UserCourseGrade> userCourseGrades = new ArrayList<>();
}
