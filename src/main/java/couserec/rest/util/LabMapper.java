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
    FinishedCourseDTO getFinishedCourseDto(FinishedCourse finishedCourse);
    List<FinishedCourseDTO> getFinishedCourseDto(List<FinishedCourse> finishedCourses);

    GroupCourseDTO getGroupCourseDto(GroupCourse groupCourse);
    List<GroupCourseDTO> getGroupCourseDto(List<GroupCourse> groupCourses);
}

