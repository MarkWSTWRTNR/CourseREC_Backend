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
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @EqualsAndHashCode.Exclude
    @Column(unique = true)
    private Integer programId;
    private String name;

    @Builder.Default
            @OneToMany
    List<Course> GE = new ArrayList<>();

}
