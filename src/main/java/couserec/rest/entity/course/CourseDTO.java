package couserec.rest.entity.course;

import couserec.rest.entity.comment.CommentDTO;
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
public class CourseDTO {
    int id;
    String courseId;
    String name;
    int credit;
    String gradingtype;
    String description;
    List<CourseDTO> prerequisite;
    @Builder.Default
    List<CourseOwnGroupCourseDTO> groupCourses = new ArrayList<>();
    List<CourseOwnFinishedGroupCourseDTO> finishedGroupCourse;
    @Builder.Default
    List<CourseOwnStandardStudyPlanDTO> standardStudyPlans = new ArrayList<>();
    List<CommentDTO> comments;

}
