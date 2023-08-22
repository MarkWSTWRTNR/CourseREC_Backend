package couserec.rest.util;
import couserec.rest.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface LabMapper {
LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    //Program

    ProgramDTO getProgramDto(Program program);

    List<ProgramDTO> getProgramDto(List<Program> programs);
    //Faculty

    FacultyDTO getFacultyDto(Faculty faculty);

    List<FacultyDTO> getFacultyDto(List<Faculty> facultys);
    //Course
    CourseDTO getCourseDto(Course course);
    List<CourseDTO> getCourseDto(List<Course> courses);
    //Student
    FinishedGroupCourseDTO getFinishedGroupCourseDto(FinishedGroupCourse finishedGroupCourse);
    List<FinishedGroupCourseDTO> getFinishedGroupCourseDto(List<FinishedGroupCourse> finishedGroupCourse);

    GroupCourseDTO getGroupCourseDto(GroupCourse groupCourse);
    List<GroupCourseDTO> getGroupCourseDto(List<GroupCourse> groupCourses);

    StandardStudyPlanDTO getStandardStudyPlanDto(StandardStudyPlan standardStudyPlan);
    List<StandardStudyPlanDTO> getStandardStudyPlanDto(List<StandardStudyPlan> standardStudyPlan);

    CommentDTO getCommentDto(Comment comment);
    List<CommentDTO> getCommentDto(List<Comment> comment);
}

