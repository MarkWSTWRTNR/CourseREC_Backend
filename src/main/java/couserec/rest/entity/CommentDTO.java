package couserec.rest.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    int id;
    String comment;
    int ratingScore;
    CommentOwnCourseDTO course;
    CommentOwnUserDTO user;
}
