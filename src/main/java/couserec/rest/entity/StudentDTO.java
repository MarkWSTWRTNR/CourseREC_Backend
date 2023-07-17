package couserec.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    int id;
    String name;
    String year;
    String semester;
    int credit;
    String grade;
    double gpa;
    double gpax;
    double majorgpax;
    List<CourseOwnStudentDTO> courses;
}
