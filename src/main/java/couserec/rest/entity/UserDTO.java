package couserec.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Builder.Default
    List<UserOwnCommentDTO> comments = new ArrayList<>();
    @Builder.Default
    List<UserOwnFinishedGroupCourseDTO> finishedGroupCourses = new ArrayList<>();
}
