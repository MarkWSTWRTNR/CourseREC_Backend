package couserec.rest.config;

import couserec.rest.entity.Course;
import couserec.rest.entity.Faculty;
import couserec.rest.entity.Program;
import couserec.rest.repository.CourseRepository;
import couserec.rest.repository.FacultyRepository;
import couserec.rest.repository.ProgramRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ProgramRepository programRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        courseRepository.save(Course.builder()
                .courseId("001001")
                .name("English 1")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        courseRepository.save(Course.builder()
                .courseId("953234")
                .name("Dev-ops")
                .credit(3)
                .gradingtype("Letter grading")
                .description("Details")
                .build());
        Program p = programRepository.save(Program.builder().name("SE").programId("01").build());
        Program p2 = programRepository.save(Program.builder().name("ani").programId("02").build());
        Faculty f = facultyRepository.save(Faculty.builder().facultyId("01").name("CAMT").build());
        f.getPrograms().add(p);
        p.setFaculties(f);
        f.getPrograms().add(p2);
        p2.setFaculties(f);
//        Course a = courseRepository.save(
//                Course.builder()
//                        .courseId("953331").name("A").build()
//        );
//        a.setName("hello");
//        Course b = courseRepository.save(
//                Course.builder().courseId("001001").name("Eng").build()
//        );
//        b.getPrerequisite().add(a);
    }
}
