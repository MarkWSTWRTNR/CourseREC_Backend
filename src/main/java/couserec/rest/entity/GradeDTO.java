package couserec.rest.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class GradeDTO {
    @Enumerated(EnumType.STRING)
    private Grade grade;
    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
