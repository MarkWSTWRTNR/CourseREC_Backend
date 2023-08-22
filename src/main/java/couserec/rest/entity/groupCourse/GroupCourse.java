package couserec.rest.entity.groupCourse;

import couserec.rest.entity.program.Program;
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
public class GroupCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    int id;
    String text;
    int credit;
    String groupName;
    @ManyToMany
            @Builder.Default
    List<Course> courses = new ArrayList<>();
    @ManyToOne
    Program programs;
}
