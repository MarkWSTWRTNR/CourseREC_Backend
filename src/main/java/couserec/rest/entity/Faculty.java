package couserec.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private int id;


    @Column(unique = true)
    private String facultyId;
    private String name;


    @OneToMany(mappedBy = "faculties")
    @JsonManagedReference
    @Builder.Default
    List<Program> programs = new ArrayList<>();
}
