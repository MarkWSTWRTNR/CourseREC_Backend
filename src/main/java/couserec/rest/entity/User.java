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
public class User {

    @ManyToMany
    @Builder.Default
    List<FinishedGroupCourse> finishedGroupCourses = new ArrayList<>();
    @OneToMany
    @Builder.Default
    List<Comment> comments = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}

