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
public class GroupCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    int id;
    String text;
    int credit;
    String groupName;
    @ManyToMany
    List<Course> courses = new ArrayList<>();
    @OneToOne(mappedBy = "groupCourses")
    Program programs;
}
