package couserec.rest.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GroupCourse {
    String groupName;
    int credit;
    List<Course> courses;
}
