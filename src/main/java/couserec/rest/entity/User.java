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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserCourseGrade> userCourseGrades = new ArrayList<>();
    public void addCourseGrade(Course course, Grade newGrade) {
        // Find an existing grade for the same course
        UserCourseGrade existingGrade = userCourseGrades.stream()
                .filter(grade -> grade.getCourse().equals(course))
                .findFirst()
                .orElse(null);

        if (existingGrade != null) {
            // Update the existing grade with the new value
            existingGrade.setGrade(newGrade);
        } else {
            // Create a new grade instance and associate it with the user and course
            UserCourseGrade userCourseGrade = new UserCourseGrade();
            userCourseGrade.setUser(this);
            userCourseGrade.setCourse(course);
            userCourseGrade.setGrade(newGrade);

            userCourseGrades.add(userCourseGrade);
            course.getUserCourseGrades().add(userCourseGrade);
        }
    }


    public void removeCourseGrade(Course course) {
        userCourseGrades.removeIf(userCourseGrade -> userCourseGrade.getCourse().equals(course));
        course.getUserCourseGrades().removeIf(userCourseGrade -> userCourseGrade.getUser().equals(this));
    }

}

