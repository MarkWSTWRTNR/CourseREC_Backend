package couserec.rest.entity;

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
public class FinishedGroupCourseDTO {
    int id;
    String year;
    String semester;

    @Builder.Default
    List<FinishedGroupCourseOwnCourseDTO> courses =new ArrayList<>();
    @Builder.Default
    List<FinishedGroupCourseOwnUserDTO> users = new ArrayList<>();
}
