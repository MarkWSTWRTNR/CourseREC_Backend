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

import java.util.ArrayList;
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

        for (Course course : program.getGerclp()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            existingProgram.getGerclp().add(existingCourse);
        }

        for (Course course : program.getGercic()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            existingProgram.getGercic().add(existingCourse);
        }

        for (Course course : program.getGercac()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            existingProgram.getGercac().add(existingCourse);
        }

        for (Course course : program.getGeec()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            existingProgram.getGeec().add(existingCourse);
        }

        for (Course course : program.getFoscc()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            existingProgram.getFoscc().add(existingCourse);
        }

        for (Course course : program.getFosmcrc()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            existingProgram.getFosmcrc().add(existingCourse);
        }

        for (Course course : program.getFosme()) {
            Course existingCourse = courseDao.getCourseByCourseId(course.getCourseId());
            existingProgram.getFosme().add(existingCourse);
        }
        existingProgram.setFreeElective(program.getFreeElective());
        return programDao.addCourseToProgram(existingProgram);
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
