package couserec.rest.entity.comment;

import couserec.rest.entity.course.CourseDTO;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    int id;
    String comment;
    CourseDTO course;
}
