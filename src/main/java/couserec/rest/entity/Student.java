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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private int id;

    String name;
    String year;
    String semester;
    int credit;
    String grade;
    double gpa;
    double gpax;
    double majorgpax;

    @ManyToMany
    List<Course> courses;
}
