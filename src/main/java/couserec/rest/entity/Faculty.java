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
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    int id;
    @Column(unique = true)
    String facultyId;
    String name;
    @OneToMany(mappedBy = "faculty")
    @Builder.Default
    List<Program> programs = new ArrayList<>();

}
