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
    int credit;
//    @Builder.Default
//    @OneToMany
//    List<Course> gerclp = new ArrayList<>();
//    List<Course> gercIc = new ArrayList<>();
//    List<Course> gercac = new ArrayList<>();
//    List<Course> geec = new ArrayList<>();
//    List<Course> foscc = new ArrayList<>();
//    List<Course> fosmcrc  = new ArrayList<>();
//    List<Course> fosme  = new ArrayList<>();


}
