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
    @Column(unique = true)
    String groupName;
    @ManyToMany
            @Builder.Default
    List<Course> courses = new ArrayList<>();
    @ManyToOne
    Program programs;
}
