package couserec.rest.entity;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupCourseDTO {
    int id;
    String text;
    int credit;
    String groupName;
    @Builder.Default
    List<GroupCourseOwnCourseDTO> courses = new ArrayList<>();
    GroupCourseOwnProgramDTO programs;
}
