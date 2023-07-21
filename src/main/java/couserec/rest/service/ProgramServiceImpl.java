package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.dao.FacultyDao;
import couserec.rest.dao.ProgramDao;
import couserec.rest.entity.Course;
import couserec.rest.entity.Faculty;
import couserec.rest.entity.Program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProgramServiceImpl implements ProgramService{

    @Autowired
    ProgramDao programDao;
    @Autowired
    FacultyDao facultyDao;
    @Autowired
    CourseDao courseDao;
    @Transactional
    public Program saveProgram(Program program) {
        Faculty faculty = facultyDao.getFacultyByFacultyId(program.getFaculty().getFacultyId());
        program.setFaculty(faculty);
        faculty.getPrograms().add(program);
        return programDao.saveProgram(program);
    }
    @Transactional
    public Program addCourseToProgram(Program program) {
        Program existingProgram = programDao.getProgramByProgramId(program.getProgramId());

        if (existingProgram == null) {
            // Program doesn't exist, return null or handle the error case.
            return null;
        }


        if (program.getGerclp() != null) {
            for (Course course : program.getGerclp()) {
                Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
                if (existingCourse != null && !existingProgram.getGerclp().contains(existingCourse)) {
                    existingProgram.getGerclp().add(existingCourse);
                }
            }
        }

        if (program.getGercic() != null) {
            for (Course course : program.getGercic()) {
                Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
                if (existingCourse != null && !existingProgram.getGercic().contains(existingCourse)) {
                    existingProgram.getGercic().add(existingCourse);
                }
            }
        }
        if (program.getGercac() != null) {
            for (Course course : program.getGercac()) {
                Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
                if (existingCourse != null && !existingProgram.getGercac().contains(existingCourse)) {
                    existingProgram.getGercac().add(existingCourse);
                }

            }
        }
        if (program.getGeec() != null) {
            for (Course course : program.getGeec()) {
                Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
                if (existingCourse != null && !existingProgram.getGeec().contains(existingCourse)) {
                    existingProgram.getGeec().add(existingCourse);
                }
            }
        }
        if (program.getFoscc() != null) {
            for (Course course : program.getFoscc()) {
                Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
                if (existingCourse != null && !existingProgram.getFoscc().contains(existingCourse)) {
                    existingProgram.getFoscc().add(existingCourse);
                }
            }
        }
        if (program.getFosmcrc() != null) {
            for (Course course : program.getFosmcrc()) {
                Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
                if (existingCourse != null && !existingProgram.getFosmcrc().contains(existingCourse)) {
                    existingProgram.getFosmcrc().add(existingCourse);
                }
            }
        }
        if (program.getFosme() != null) {
            for (Course course : program.getFosme()) {
                Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
                if (existingCourse != null && !existingProgram.getFosme().contains(existingCourse)) {
                    existingProgram.getFosme().add(existingCourse);
                }
            }
        }
        existingProgram.setFreeElective(program.getFreeElective());
        return programDao.addCourseToProgram(existingProgram);
    }
    @Transactional
    @Override
    public Program removeCourseFromProgram(String programId, String courseId) {
        Program existingProgram = programDao.getProgramByProgramId(programId);

        if (existingProgram == null) {
            // Program doesn't exist, return null or handle the error case.
            return null;
        }

        // Remove the course from each section if it exists
        removeCourseFromSection(existingProgram.getGerclp(), courseId);
        removeCourseFromSection(existingProgram.getGercic(), courseId);
        removeCourseFromSection(existingProgram.getGercac(), courseId);
        removeCourseFromSection(existingProgram.getGeec(), courseId);
        removeCourseFromSection(existingProgram.getFoscc(), courseId);
        removeCourseFromSection(existingProgram.getFosmcrc(), courseId);
        removeCourseFromSection(existingProgram.getFosme(), courseId);

        return programDao.addCourseToProgram(existingProgram);
    }

    private void removeCourseFromSection(List<Course> courseList, String courseId) {
        if (courseList != null) {
            courseList.removeIf(course -> courseId.equals(course.getCourseId()));
        }
    }

    public List<Program> getPrograms() {
        return programDao.getPrograms();
    }

    public Program getProgramById(int id) {
        return programDao.getProgramById(id);
    }
    @Transactional
    public Program updateProgram(Program program) {
        Program existingProgram = programDao.getProgramByProgramId(program.getProgramId());
        if (existingProgram == null) {
            return null;
        }

        // Update the program information
        existingProgram.setProgramId(program.getProgramId());
        existingProgram.setName(program.getName());

        // Update the program's faculty
        Faculty faculty = facultyDao.getFacultyByFacultyId(program.getFaculty().getFacultyId());
        existingProgram.setFaculty(faculty);

        return programDao.updateProgram(existingProgram);
    }

    @Override
    public String deleteProgram(int id) {
        return programDao.deleteProgram(id);
    }

    @Override
    public Program getProgramByProgramId(String programId){
        return programDao.getProgramByProgramId(programId);
    }
}
