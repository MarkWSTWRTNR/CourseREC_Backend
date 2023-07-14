package couserec.rest.util;
import couserec.rest.entity.Faculty;
import couserec.rest.entity.FacultyDTO;
import couserec.rest.entity.Program;
import couserec.rest.entity.ProgramDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface LabMapper {
LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);


    ProgramDTO getProgramDto(Program program);
    List<ProgramDTO> getProgramDto(List<Program> programs);
    FacultyDTO getFacultyDto(Faculty faculty);
    List<FacultyDTO> getFacultyDto(List<Faculty> facultys);
}

