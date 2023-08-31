package couserec.rest.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseGradeDTO {
    private Long id;
    private UserCourseGradeOwnUserDTO user;
    private UserCourseGradeOwnCourseDTO course;

    @Enumerated(EnumType.STRING)
    private Grade grade;
}
