package couserec.rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int credit;
    @Column(unique = true)
    private String name;
    @Builder.Default
    @OneToMany
    private List<Course> gerclp = new ArrayList<>();
    @Builder.Default
    @OneToMany
    private List<Course> gercIc = new ArrayList<>();
    @Builder.Default
    @OneToMany
    private List<Course> gercac = new ArrayList<>();
    @Builder.Default
    @OneToMany
    private List<Course> geec = new ArrayList<>();
    @Builder.Default
    @OneToMany
    private List<Course> foscc = new ArrayList<>();
    @Builder.Default
    @OneToMany
    private List<Course> fosmcrc = new ArrayList<>();
    @Builder.Default
    @OneToMany
    private List<Course> fosme = new ArrayList<>();
}
