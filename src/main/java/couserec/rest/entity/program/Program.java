package couserec.rest.entity.program;

import couserec.rest.entity.standardStudyPlan.StandardStudyPlan;
import couserec.rest.entity.faculty.Faculty;
import couserec.rest.entity.groupCourse.GroupCourse;
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

    @OneToMany(mappedBy = "programs")
    @Builder.Default
    List<StandardStudyPlan> standardStudyPlans = new ArrayList<>();
}
