package couserec.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    @Column(unique = true)
    private Long courseId;
    private String name;

    private Long credit;

    private String gradingtype;
    private String description;

//    @ManyToMany
//    @JoinTable(name = "course_prerequisites",
//            joinColumns = @JoinColumn(name = "courseId"),
//            inverseJoinColumns = @JoinColumn(name = "prerequisite_id"))
//    private List<Course> prerequisites;
//
//    public List<Course> getPrerequisites() {
//        return prerequisites;
//    }
//
//    public void setPrerequisites(List<Course> prerequisites) {
//        this.prerequisites = prerequisites;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public String getGradingtype() {
        return gradingtype;
    }

    public void setGradingtype(String gradingtype) {
        this.gradingtype = gradingtype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
