package couserec.rest.config;

import couserec.rest.entity.*;
//import couserec.rest.entity.Curriculum;
import couserec.rest.repository.*;

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
    @Autowired
    GroupCourseRepository groupCourseRepository;
    @Autowired
    StandardStudyPlanRepository standardStudyPlanRepository;

    @Autowired
    FinishedGroupCourseRepository finishedGroupCourseRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
       Course English1 = courseRepository.save(Course.builder()
                .courseId("001001")
                .name("Fundamental English 1")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course English2 = courseRepository.save(Course.builder()
                .courseId("001102")
                .name("Fundamental English 2")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course English3 = courseRepository.save(Course.builder()
                .courseId("001201")
                .name("Critical Reading and Effective Writing")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course English4 = courseRepository.save(Course.builder()
                .courseId("001225")
                .name("English in Science and Technology Context")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course ModernLife = courseRepository.save(Course.builder()
                .courseId("204100")
                .name("Information Technology and Modern Life")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course InternetAndOnlineCommunity = courseRepository.save(Course.builder()
                .courseId("261111")
                .name("Internet and Online Community")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Reasoning = courseRepository.save(Course.builder()
                .courseId("011151")
                .name("Reasoning")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Psychology = courseRepository.save(Course.builder()
                .courseId("013110")
                .name("Psychology and Daily Life")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course ModernWorld = courseRepository.save(Course.builder()
                .courseId("159100")
                .name("Modern World in Everyday Life")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course CriticalThinking = courseRepository.save(Course.builder()
                .courseId("571111")
                .name("Critical Thinking and Creative Thinking")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course IntroToEntreBusiness = courseRepository.save(Course.builder()
                .courseId("703103")
                .name("Introduction to Entrepreneurship and Business")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Citizenship = courseRepository.save(Course.builder()
                .courseId("140104")
                .name("Citizenship")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Swimming = courseRepository.save(Course.builder()
                .courseId("057122")
                .name("Swimming for Life and Exercise")
                .credit(1)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Badminton = courseRepository.save(Course.builder()
                .courseId("057127")
                .name("Badminton for Life and Exercise")
                .credit(1)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Philosophy  = courseRepository.save(Course.builder()
                .courseId("011269")
                .name("Philosophy of Sufficiency Economy")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Equilibrium  = courseRepository.save(Course.builder()
                .courseId("571113")
                .name("Maintaining the Equilibrium in Adolescent Life")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Finance  = courseRepository.save(Course.builder()
                .courseId("702101")
                .name("Finance for Daily Life")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Lanna   = courseRepository.save(Course.builder()
                .courseId("159151")
                .name("Lanna Society and Culture")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Environmental   = courseRepository.save(Course.builder()
                .courseId("154104")
                .name("Environmental Conservation")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course DoiSuthepStudy  = courseRepository.save(Course.builder()
                .courseId("201192")
                .name("Doi Suthep Study")
                .credit(1)
                .gradingtype("Letter Grading")
                .description("details").build());
        Course Animation  = courseRepository.save(Course.builder()
                .courseId("951100")
                .name("Modern Life and Animation")
                .credit(3)
                .gradingtype("Letter Grading")
                .description("details").build());

     Course math113 = courseRepository.save(Course.builder()
             .courseId("206113")
             .name("Calculus for Software Technology")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course math255 = courseRepository.save(Course.builder()
             .courseId("206255")
             .name("Mathematics for Software Technology")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course math281 = courseRepository.save(Course.builder()
             .courseId("206281")
             .name("Discrete Mathematics")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course stat263 = courseRepository.save(Course.builder()
             .courseId("208263")
             .name("Elementary Statistics")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se100 = courseRepository.save(Course.builder()
             .courseId("953100")
             .name("Computers and Programming")
             .credit(2)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se102 = courseRepository.save(Course.builder()
             .courseId("953102")
             .name("Abstract Data Type and Problem Solving")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se201 = courseRepository.save(Course.builder()
             .courseId("953201")
             .name("Algorithms Design and Analysis")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se202 = courseRepository.save(Course.builder()
             .courseId("953202")
             .name("Introduction to Software Engineering")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se231 = courseRepository.save(Course.builder()
             .courseId("953231")
             .name("Object Oriented Programming")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course atge102 = courseRepository.save(Course.builder()
             .courseId("955102")
             .name("Digital Literacy")
             .credit(2)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course atge103 = courseRepository.save(Course.builder()
             .courseId("955103")
             .name("Programming Logical Thinking")
             .credit(2)
             .gradingtype("Letter Grading")
             .description("details")
             .build());
     Course se211 = courseRepository.save(Course.builder()
             .courseId("953211")
             .name("Computer Organization")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se212 = courseRepository.save(Course.builder()
             .courseId("953212")
             .name("Database Systems and Database Systems Design")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se214 = courseRepository.save(Course.builder()
             .courseId("953214")
             .name("Operating System and Computer Networks")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se233 = courseRepository.save(Course.builder()
             .courseId("953233")
             .name("Advanced Programming")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se234 = courseRepository.save(Course.builder()
             .courseId("953234")
             .name("Basic Development and Operations")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se251 = courseRepository.save(Course.builder()
             .courseId("953251")
             .name("Human Factors in Digital Interaction Design")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se262 = courseRepository.save(Course.builder()
             .courseId("953262")
             .name("Front-end and Web Development Foundation")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se321 = courseRepository.save(Course.builder()
             .courseId("953321")
             .name("Software Requirement Analysis")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se322 = courseRepository.save(Course.builder()
             .courseId("953322")
             .name("Software Design and Architecture")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se323 = courseRepository.save(Course.builder()
             .courseId("953323")
             .name("Software Construction and Testing")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se331 = courseRepository.save(Course.builder()
             .courseId("953331")
             .name("Component-Based Software Development")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se420 = courseRepository.save(Course.builder()
             .courseId("953420")
             .name("Ethics and Professionalism for Software Engineers")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se422 = courseRepository.save(Course.builder()
             .courseId("953422")
             .name("Software Quality Assurance")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se445 = courseRepository.save(Course.builder()
             .courseId("953445")
             .name("Introduction to Software Business")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se491 = courseRepository.save(Course.builder()
             .courseId("953491")
             .name("Cooperative Education")
             .credit(9)
             .gradingtype("Letter Grading")
             .description("details")
             .build());

     Course se499 = courseRepository.save(Course.builder()
             .courseId("953499")
             .name("Software Engineering Project")
             .credit(3)
             .gradingtype("Letter Grading")
             .description("details")
             .build());
     English2.getPrerequisite().add(English1);
     English3.getPrerequisite().add(English2);
     English4.getPrerequisite().add(English3);
     se201.getPrerequisite().add(se100);
        // Create Faculty instances
        Faculty Camt = facultyRepository.save(Faculty.builder().facultyId("01").name("College of Arts, Media, and Technology.").build());
        Faculty ECON = facultyRepository.save(Faculty.builder().facultyId("02").name("ECON.").build());

// Create Program instances
        Program SE = programRepository.save(Program.builder().name("Software Engineering").programId("01").build());
        Program DII = programRepository.save(Program.builder().name("DII").programId("02").build());


// Create GroupCourse instance for GE
        GroupCourse GESE = groupCourseRepository.save(GroupCourse.builder().groupName("General Education | Required courses | Learner Pereson").credit(15).build());
        GroupCourse FOSCCSE = groupCourseRepository.save(GroupCourse.builder().groupName("Feild of Specialization| Core Courses").credit(15).build());
        GroupCourse GEDII = groupCourseRepository.save(GroupCourse.builder().groupName("General Education | Required courses | Learner Pereson").credit(15).build());
        GroupCourse FOSCCDII = groupCourseRepository.save(GroupCourse.builder().groupName("Feild of Specialization| Core Courses").credit(15).build());
        StandardStudyPlan Y1S1SE = standardStudyPlanRepository.save(StandardStudyPlan.builder().yearAndSemester("Year1 Semester1").credit(75).build());
        StandardStudyPlan Y1S1DII = standardStudyPlanRepository.save(StandardStudyPlan.builder().yearAndSemester("Year1 Semester1").credit(75).build());

        FinishedGroupCourse Y1S1 = finishedGroupCourseRepository.save(FinishedGroupCourse.builder().year("1").semester("1").build());

        User pon = userRepository.save(User.builder().username("phonkrit_c").password("632115031").role(UserRole.ROLE_STUDENT).build());

        pon.getFinishedGroupCourses().add(Y1S1);
        Y1S1.getUsers().add(pon);
        Y1S1.getCourses().add(se234);
        se234.getFinishedGroupCourses().add(Y1S1);
        Y1S1.getCourses().add(se211);
        se211.getFinishedGroupCourses().add(Y1S1);
        Y1S1.getCourses().add(se212);
        se212.getFinishedGroupCourses().add(Y1S1);
        Y1S1.getCourses().add(English1);
        English1.getFinishedGroupCourses().add(Y1S1);

        Camt.getPrograms().add(SE);
        SE.setFaculty(Camt);
        Camt.getPrograms().add(DII);
        DII.setFaculty(Camt);

        SE.getGroupCourses().add(GESE);
        GESE.setPrograms(SE);
        SE.getGroupCourses().add(FOSCCSE);
        FOSCCSE.setPrograms(SE);
        SE.getStandardStudyPlans().add(Y1S1SE);
        Y1S1SE.setPrograms(SE);

        DII.getGroupCourses().add(GEDII);
        GEDII.setPrograms(DII);
        DII.getStandardStudyPlans().add(Y1S1DII);
        Y1S1DII.setPrograms(DII);
        DII.getGroupCourses().add(FOSCCDII);
        FOSCCDII.setPrograms(DII);
        FOSCCDII.getCourses().add(English2);
        English2.getGroupCourses().add(FOSCCDII);
        GESE.getCourses().add(English1);
        English1.getGroupCourses().add(GESE);
        FOSCCSE.getCourses().add(English2);
        English2.getGroupCourses().add(FOSCCSE);
        GESE.getCourses().add(se211);
        se211.getGroupCourses().add(GESE);

        GEDII.getCourses().add(English1);
        English1.getGroupCourses().add(GEDII);

        Y1S1SE.getCourses().add(se100);
        se100.getStandardStudyPlans().add(Y1S1SE);

        Y1S1DII.getCourses().add(se211);
        se211.getStandardStudyPlans().add(Y1S1DII);
    }
}
