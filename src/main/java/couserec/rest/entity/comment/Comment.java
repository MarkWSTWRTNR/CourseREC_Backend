package couserec.rest.entity.comment;

import couserec.rest.entity.course.Course;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    int id;
    String comment;

    @ManyToOne
    Course course;
}
