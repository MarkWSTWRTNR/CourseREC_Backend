package couserec.rest.entity.finishedGroupCourse;

import couserec.rest.entity.course.Course;
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

    String name;
    String year;
    String semester;
    int credit;
    String grade;
    double gpa;
    double gpax;
    double majorgpax;

    @ManyToMany
            @Builder.Default
    List<Course> courses =new ArrayList<>();
}
