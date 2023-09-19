package couserec.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ManyToMany(mappedBy = "users")
    @Builder.Default
    List<FinishedGroupCourse> finishedGroupCourses = new ArrayList<>();
    @OneToMany(mappedBy = "user")
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<UserCourseGrade> userCourseGrades = new ArrayList<>();

    @ManyToOne
    private Program programs;
}

