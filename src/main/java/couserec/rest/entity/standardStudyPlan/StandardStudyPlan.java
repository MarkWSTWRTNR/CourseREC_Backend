package couserec.rest.entity.standardStudyPlan;

import couserec.rest.entity.course.Course;
import couserec.rest.entity.program.Program;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StandardStudyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    int id;
    String text;
    int credit;
    String yearAndSemester;

    @ManyToMany
    @Builder.Default
    List<Course> courses = new ArrayList<>();

    @ManyToOne
    Program programs;

}
