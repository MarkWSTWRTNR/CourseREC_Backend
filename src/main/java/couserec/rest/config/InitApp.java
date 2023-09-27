package couserec.rest.config;

import couserec.rest.entity.*;
import couserec.rest.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;


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
        Course ENGL101 = courseRepository.save(Course.builder().courseId("001001").name("Fundamental English 1").credit(3).gradingtype("Letter Grading").description("details").build());
        Course ENGL102 = courseRepository.save(Course.builder().courseId("001102").name("Fundamental English 2").credit(3).gradingtype("Letter Grading").description("details").build());
        Course ENGL201 = courseRepository.save(Course.builder().courseId("001201").name("Critical Reading and Effective Writing").credit(3).gradingtype("Letter Grading").description("details").build());
        Course ENGL225 = courseRepository.save(Course.builder().courseId("001225").name("English in Science and Technology Context").credit(3).gradingtype("Letter Grading").description("details").build());
        Course CS100 = courseRepository.save(Course.builder().courseId("204100").name("Information Technology and Modern Life").credit(3).gradingtype("Letter Grading").description("details").build());
        Course CPE111 = courseRepository.save(Course.builder().courseId("261111").name("Internet and Online Community").credit(3).gradingtype("Letter Grading").description("details").build());
        Course PHIL151 = courseRepository.save(Course.builder().courseId("011151").name("Reasoning").credit(3).gradingtype("Letter Grading").description("details").build());
        Course PSY110 = courseRepository.save(Course.builder().courseId("013110").name("Psychology  and Daily Life").credit(3).gradingtype("Letter Grading").description("details").build());
        Course SA100 = courseRepository.save(Course.builder().courseId("159100").name("Modern World in Everyday Life").credit(3).gradingtype("Letter Grading").description("details").build());
        Course NGGE111 = courseRepository.save(Course.builder().courseId("571111").name("Critical Thinking and Creative Thinking").credit(3).gradingtype("Letter Grading").description("details").build());
        Course MGMT103 = courseRepository.save(Course.builder().courseId("703103").name("Introduction to Entrepreneurship and Business").credit(3).gradingtype("Letter Grading").description("details").build());
        Course PG104 = courseRepository.save(Course.builder().courseId("140104").name("Citizenship").credit(3).gradingtype("Letter Grading").description("details").build());
        Course EDPE122 = courseRepository.save(Course.builder().courseId("057122").name("Swimming for Life and Exercise").credit(1).gradingtype("Letter Grading").description("details").build());
        Course EDPE127 = courseRepository.save(Course.builder().courseId("057127").name("Badminton for Life and Exercise").credit(1).gradingtype("Letter Grading").description("details").build());
        Course PHIL269 = courseRepository.save(Course.builder().courseId("011269").name("Philosophy  of Sufficiency Economy").credit(3).gradingtype("Letter Grading").description("details").build());
        Course NGGE113 = courseRepository.save(Course.builder().courseId("571113").name("Maintaining the Equilibrium in Adolescent Life").credit(3).gradingtype("Letter Grading").description("details").build());
        Course FINA101 = courseRepository.save(Course.builder().courseId("702101").name("Finance for Daily Life").credit(3).gradingtype("Letter Grading").description("details").build());
        Course SA151 = courseRepository.save(Course.builder().courseId("159151").name("Lanna Society and Culture").credit(3).gradingtype("Letter Grading").description("details").build());
        Course GEO104 = courseRepository.save(Course.builder().courseId("154104").name("Environmental Conservation").credit(3).gradingtype("Letter Grading").description("details").build());
        Course SC192 = courseRepository.save(Course.builder().courseId("201192").name("Doi Suthep Study").credit(1).gradingtype("Letter Grading").description("details").build());
        Course ANI100 = courseRepository.save(Course.builder().courseId("951100").name("Modern Life and Animation").credit(3).gradingtype("Letter Grading").description("details").build());

        Course math113 = courseRepository.save(Course.builder().courseId("206113").name("Calculus for Software Technology").credit(3).gradingtype("Letter Grading").description("details").build());

        Course math255 = courseRepository.save(Course.builder().courseId("206255").name("Mathematics for Software Technology").credit(3).gradingtype("Letter Grading").description("details").build());

        Course math281 = courseRepository.save(Course.builder().courseId("206281").name("Discrete Mathematics").credit(3).gradingtype("Letter Grading").description("details").build());

        Course stat263 = courseRepository.save(Course.builder().courseId("208263").name("Elementary Statistics").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se100 = courseRepository.save(Course.builder().courseId("953100").name("Computers and Programming").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se102 = courseRepository.save(Course.builder().courseId("953102").name("Abstract Data Type and Problem Solving").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se201 = courseRepository.save(Course.builder().courseId("953201").name("Algorithms Design and Analysis").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se202 = courseRepository.save(Course.builder().courseId("953202").name("Introduction to Software Engineering").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se231 = courseRepository.save(Course.builder().courseId("953231").name("Object Oriented Programming").credit(3).gradingtype("Letter Grading").description("details").build());

        Course atge102 = courseRepository.save(Course.builder().courseId("955102").name("Digital Literacy").credit(2).gradingtype("Letter Grading").description("details").build());

        Course atge103 = courseRepository.save(Course.builder().courseId("955103").name("Programming Logical Thinking").credit(2).gradingtype("Letter Grading").description("details").build());
        Course se211 = courseRepository.save(Course.builder().courseId("953211").name("Computer Organization").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se212 = courseRepository.save(Course.builder().courseId("953212").name("Database Systems and Database Systems Design").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se214 = courseRepository.save(Course.builder().courseId("953214").name("Operating System and Computer Networks").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se233 = courseRepository.save(Course.builder().courseId("953233").name("Advanced Programming").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se234 = courseRepository.save(Course.builder().courseId("953234").name("Basic Development and Operations").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se251 = courseRepository.save(Course.builder().courseId("953251").name("Human Factors in Digital Interaction Design").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se262 = courseRepository.save(Course.builder().courseId("953262").name("Front-end and Web Development Foundation").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se321 = courseRepository.save(Course.builder().courseId("953321").name("Software Requirement Analysis").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se322 = courseRepository.save(Course.builder().courseId("953322").name("Software Design and Architecture").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se323 = courseRepository.save(Course.builder().courseId("953323").name("Software Construction and Testing").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se331 = courseRepository.save(Course.builder().courseId("953331").name("Component-Based Software Development").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se420 = courseRepository.save(Course.builder().courseId("953420").name("Ethics and Professionalism for Software Engineers").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se422 = courseRepository.save(Course.builder().courseId("953422").name("Software Quality Assurance").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se445 = courseRepository.save(Course.builder().courseId("953445").name("Introduction to Software Business").credit(3).gradingtype("Letter Grading").description("details").build());

        Course se491 = courseRepository.save(Course.builder().courseId("953491").name("Cooperative Education").credit(9).gradingtype("Letter Grading").description("details").build());

        Course se499 = courseRepository.save(Course.builder().courseId("953499").name("Software Engineering Project").credit(3).gradingtype("Letter Grading").description("details").build());
        Course se324 = courseRepository.save(Course.builder().courseId("953324").name("Software Project Management").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se325 = courseRepository.save(Course.builder().courseId("953325").name("Advanced Software Development Techniques").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se326 = courseRepository.save(Course.builder().courseId("953326").name("Automated Software Testing").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se327 = courseRepository.save(Course.builder().courseId("953327").name("Software Metrics").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se351 = courseRepository.save(Course.builder().courseId("953351").name("User Experience for Software Design").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se352 = courseRepository.save(Course.builder().courseId("953352").name("Advanced User Experience for Software Design").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se362 = courseRepository.save(Course.builder().courseId("953362").name("IoT and Embedded Programming for Software Engineering 1").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se363 = courseRepository.save(Course.builder().courseId("953363").name("IoT and Embedded Programming for Software Engineering 2").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se411 = courseRepository.save(Course.builder().courseId("953411").name("Artificial Intelligence for Software Engineering").credit(3).gradingtype("Letter Grading").description("3(2-2-5)").build());
        Course se423 = courseRepository.save(Course.builder().courseId("953423").name("Software Process Improvement").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se424 = courseRepository.save(Course.builder().courseId("953424").name("Agile Software Development Tools").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se441 = courseRepository.save(Course.builder().courseId("953441").name("E-Business Strategy and Architecture").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se442 = courseRepository.save(Course.builder().courseId("953442").name("Collaborative E–Business").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se444 = courseRepository.save(Course.builder().courseId("953444").name("Web Services and Microservices").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se452 = courseRepository.save(Course.builder().courseId("953452").name("Multimedia Software Design and Development").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se453 = courseRepository.save(Course.builder().courseId("953453").name("Visual Design for Digital User Interface").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se463 = courseRepository.save(Course.builder().courseId("953463").name("Wireless Communication System").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se464 = courseRepository.save(Course.builder().courseId("953464").name("Mobile Application Development").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se465 = courseRepository.save(Course.builder().courseId("953465").name("Wireless Application Technologies").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se471 = courseRepository.save(Course.builder().courseId("953471").name("Data-Intensive Application Development").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se472 = courseRepository.save(Course.builder().courseId("953472").name("Artificial Intelligence-Enabled Systems").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se481 = courseRepository.save(Course.builder().courseId("953481").name("Introduction to Information Retrieval").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se482 = courseRepository.save(Course.builder().courseId("953482").name("Natural Language Processing for Software Engineering").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se492 = courseRepository.save(Course.builder().courseId("953492").name("Special Topics in Cooperative Education 1").credit(3).gradingtype("Letter Grading").description("3(0-9-0)").build());
        Course se493 = courseRepository.save(Course.builder().courseId("953493").name("Special Topics in Cooperative Education 2").credit(3).gradingtype("Letter Grading").description("3(0-9-0)").build());
        Course se494 = courseRepository.save(Course.builder().courseId("953494").name("Selected Topics in Software Engineering 1").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());
        Course se495 = courseRepository.save(Course.builder().courseId("953495").name("Selected Topics in Software Engineering 2").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());

        //Free Elective For SE
        Course SWFEDL = courseRepository.save(Course.builder().courseId("953111").name("Software For Everyday Life").credit(3).gradingtype("Letter Grading").description("3(3-0-6)").build());

        //Set Course prerequisite
        ENGL102.getPrerequisite().add(ENGL101);
        ENGL201.getPrerequisite().add(ENGL102);
        ENGL225.getPrerequisite().add(ENGL102);
        math255.getPrerequisite().add(math113);
        math281.getPrerequisite().add(math113);
        se102.getPrerequisite().add(se100);
        se102.getPrerequisite().add(atge103);
        se201.getPrerequisite().add(se102);
        se202.getPrerequisite().add(se100);
        se202.getPrerequisite().add(atge103);
        se212.getPrerequisite().add(se100);
        se212.getPrerequisite().add(atge103);
        se214.getPrerequisite().add(se211);
        se231.getPrerequisite().add(se100);
        se231.getPrerequisite().add(atge103);
        se233.getPrerequisite().add(se231);
        se234.getPrerequisite().add(se233);
        se321.getPrerequisite().add(se202);
        se322.getPrerequisite().add(se233);
        se323.getPrerequisite().add(se234);
        se325.getPrerequisite().add(se233);
        se326.getPrerequisite().add(se331);
        se331.getPrerequisite().add(se233);
        se351.getPrerequisite().add(se251);
        se352.getPrerequisite().add(se351);
        se362.getPrerequisite().add(se214);
        se363.getPrerequisite().add(se362);
        se411.getPrerequisite().add(se102);
        se411.getPrerequisite().add(se201);
        se422.getPrerequisite().add(se202);
        se423.getPrerequisite().add(se323);
        se424.getPrerequisite().add(se234);
        se441.getPrerequisite().add(se202);
        se442.getPrerequisite().add(se202);
        se444.getPrerequisite().add(se231);
        se444.getPrerequisite().add(se214);
        se445.getPrerequisite().add(se202);
        se452.getPrerequisite().add(se202);
        se463.getPrerequisite().add(se214);
        se464.getPrerequisite().add(se202);
        se464.getPrerequisite().add(se214);
        se465.getPrerequisite().add(se202);
        se465.getPrerequisite().add(se214);
        se471.getPrerequisite().add(se102);
        se472.getPrerequisite().add(se411);
        se481.getPrerequisite().add(se201);



        // Create Faculty instances
        Faculty Camt = facultyRepository.save(Faculty.builder().facultyId("01").name("College of Arts, Media, and Technology.").build());
        Faculty ECON = facultyRepository.save(Faculty.builder().facultyId("02").name("ECON.").build());

// Create Program instances
        Program SE = programRepository.save(Program.builder().name("Software Engineering").programId("01").build());
        Program DII = programRepository.save(Program.builder().name("DII").programId("02").build());


// Create GroupCourse instance for GE
        GroupCourse SEGERCLP = groupCourseRepository.save(GroupCourse.builder().groupName("General Education | Required courses | Learner Pereson").credit(15).text("Pick one of the two course (Digital Literacy): Course ID: 204100 Information Technology and Modern Life and Course ID: 261111 Internet and Online Community").build());
        GroupCourse SEGERCICC = groupCourseRepository.save(GroupCourse.builder().groupName("General Education | Required courses | Innovative Co-creator").credit(3).build());
        GroupCourse SEGERCAC = groupCourseRepository.save(GroupCourse.builder().groupName("General Education | Required courses | Active Citizen").credit(3).build());
        GroupCourse SEGEECLPandAC = groupCourseRepository.save(GroupCourse.builder().groupName("General Education | Elective courses | Learner Person & Active Citizen").credit(9).build());
//        GroupCourse SEGEECAC = groupCourseRepository.save(GroupCourse.builder().groupName("General Education | Elective courses | Active Citizen").credit(9).build());
        GroupCourse SEFOSCC = groupCourseRepository.save(GroupCourse.builder().groupName("Field of Specialization| Core Courses").credit(30).build());
        GroupCourse SEFOSMCRC = groupCourseRepository.save(GroupCourse.builder().groupName("Field of Specialization | Major Courses | Required Courses").credit(54).build());
        GroupCourse SEFOSMCFE = groupCourseRepository.save(GroupCourse.builder().groupName("Field of Specialization | Major Courses | Free Elective").credit(9).build());
        GroupCourse SEFE = groupCourseRepository.save(GroupCourse.builder().groupName("Free Electives").credit(6).build());

        GroupCourse FOSCCDII = groupCourseRepository.save(GroupCourse.builder().groupName("Field of Specialization| Core Courses").credit(15).build());
        StandardStudyPlan SEY1S1 = standardStudyPlanRepository.save(StandardStudyPlan.builder().yearAndSemester("Year1 Semester1").credit(18).text("General Education in Digital Literacy 3 credit"+'\n'+"General Education in Elective Course 3 credit").build());
        StandardStudyPlan DIIY1S1 = standardStudyPlanRepository.save(StandardStudyPlan.builder().yearAndSemester("Year1 Semester1").credit(18).build());
        GroupCourse GEDII = groupCourseRepository.save(GroupCourse.builder().groupName("General Education | Required courses | Learner Pereson").credit(15).build());
        FinishedGroupCourse PONY1S1 = finishedGroupCourseRepository.save(FinishedGroupCourse.builder().year("1").semester("1").build());

        User pon = userRepository.save(User.builder().username("phonkrit_c").password("632115031").role(UserRole.ROLE_STUDENT).build());
        //Set User To Program
        SE.getUser().add(pon);
        pon.setPrograms(SE);
        //FinishedGroupCourse for user
        pon.getFinishedGroupCourses().add(PONY1S1);
        PONY1S1.getUsers().add(pon);
        PONY1S1.getCourses().add(ENGL101);
        ENGL101.getFinishedGroupCourses().add(PONY1S1);
        PONY1S1.getCourses().add(atge102);
        atge102.getFinishedGroupCourses().add(PONY1S1);
        PONY1S1.getCourses().add(se100);
        se100.getFinishedGroupCourses().add(PONY1S1);
        PONY1S1.getCourses().add(math113);
        math113.getFinishedGroupCourses().add(PONY1S1);
        PONY1S1.getCourses().add(ANI100);
        ANI100.getFinishedGroupCourses().add(PONY1S1);
        PONY1S1.getCourses().add(CPE111);
        CPE111.getFinishedGroupCourses().add(PONY1S1);
        PONY1S1.getCourses().add(atge103);
        atge103.getFinishedGroupCourses().add(PONY1S1);

        Camt.getPrograms().add(SE);
        SE.setFaculty(Camt);
        Camt.getPrograms().add(DII);
        DII.setFaculty(Camt);
//Set GroupCourse to faculty (SE)
        SE.getGroupCourses().add(SEGERCLP);
        SEGERCLP.setPrograms(SE);
        SE.getGroupCourses().add(SEGERCICC);
        SEGERCICC.setPrograms(SE);
        SE.getGroupCourses().add(SEGERCAC);
        SEGERCAC.setPrograms(SE);
        SE.getGroupCourses().add(SEGEECLPandAC);
        SEGEECLPandAC.setPrograms(SE);
        SE.getGroupCourses().add(SEFOSCC);
        SEFOSCC.setPrograms(SE);
        SE.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.setPrograms(SE);
        SE.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.setPrograms(SE);
        SE.getGroupCourses().add(SEFE);
        SEFE.setPrograms(SE);
//Set Course to GroupCourse (SE)
        //General Education | Required courses | Learner Pereson
        SEGERCLP.getCourses().add(ENGL101);
        ENGL101.getGroupCourses().add(SEGERCLP);
        SEGERCLP.getCourses().add(ENGL102);
        ENGL102.getGroupCourses().add(SEGERCLP);
        SEGERCLP.getCourses().add(ENGL201);
        ENGL201.getGroupCourses().add(SEGERCLP);
        SEGERCLP.getCourses().add(ENGL225);
        ENGL225.getGroupCourses().add(SEGERCLP);
        SEGERCLP.getCourses().add(CS100);
        CS100.getGroupCourses().add(SEGERCLP);
        SEGERCLP.getCourses().add(CPE111);
        CPE111.getGroupCourses().add(SEGERCLP);

        //General Education | Required courses | Innovative Co-creator
        SEGERCICC.getCourses().add(PHIL151);
        PHIL151.getGroupCourses().add(SEGERCICC);
        SEGERCICC.getCourses().add(PSY110);
        PSY110.getGroupCourses().add(SEGERCICC);
        SEGERCICC.getCourses().add(SA100);
        SA100.getGroupCourses().add(SEGERCICC);
        SEGERCICC.getCourses().add(NGGE111);
        NGGE111.getGroupCourses().add(SEGERCICC);
        SEGERCICC.getCourses().add(MGMT103);
        MGMT103.getGroupCourses().add(SEGERCICC);

        //General Education | Required courses | Active Citizen
        SEGERCAC.getCourses().add(PG104);
        PG104.getGroupCourses().add(SEGERCAC);

        //General Education | Elective courses | Learner Person & Active Citizen
        SEGEECLPandAC.getCourses().add(EDPE122);
        EDPE122.getGroupCourses().add(SEGEECLPandAC);
        SEGEECLPandAC.getCourses().add(EDPE127);
        EDPE127.getGroupCourses().add(SEGEECLPandAC);
        SEGEECLPandAC.getCourses().add(PHIL269);
        PHIL269.getGroupCourses().add(SEGEECLPandAC);
        SEGEECLPandAC.getCourses().add(NGGE113);
        NGGE113.getGroupCourses().add(SEGEECLPandAC);
        SEGEECLPandAC.getCourses().add(FINA101);
        FINA101.getGroupCourses().add(SEGEECLPandAC);
        SEGEECLPandAC.getCourses().add(SA151);
        SA151.getGroupCourses().add(SEGEECLPandAC);
        SEGEECLPandAC.getCourses().add(GEO104);
        GEO104.getGroupCourses().add(SEGEECLPandAC);
        SEGEECLPandAC.getCourses().add(SC192);
        SC192.getGroupCourses().add(SEGEECLPandAC);
        SEGEECLPandAC.getCourses().add(ANI100);
        ANI100.getGroupCourses().add(SEGEECLPandAC);

        //Field of Specialization| Core Courses
        SEFOSCC.getCourses().add(math113);
        math113.getGroupCourses().add(SEFOSCC);
        SEFOSCC.getCourses().add(math255);
        math255.getGroupCourses().add(SEFOSCC);
        SEFOSCC.getCourses().add(math281);
        math281.getGroupCourses().add(SEFOSCC);
        SEFOSCC.getCourses().add(stat263);
        stat263.getGroupCourses().add(SEFOSCC);
        SEFOSCC.getCourses().add(se100);
        se100.getGroupCourses().add(SEFOSCC);
        SEFOSCC.getCourses().add(se102);
        se102.getGroupCourses().add(SEFOSCC);
        SEFOSCC.getCourses().add(se201);
        se201.getGroupCourses().add(SEFOSCC);
        SEFOSCC.getCourses().add(se202);
        se202.getGroupCourses().add(SEFOSCC);
        SEFOSCC.getCourses().add(se231);
        se231.getGroupCourses().add(SEFOSCC);
        SEFOSCC.getCourses().add(atge102);
        atge102.getGroupCourses().add(SEFOSCC);
        SEFOSCC.getCourses().add(atge103);
        atge103.getGroupCourses().add(SEFOSCC);

        //Field of Specialization | Major Courses | Required Courses
        SEFOSMCRC.getCourses().add(se211);
        se211.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se212);
        se212.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se214);
        se214.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se233);
        se233.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se234);
        se234.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se251);
        se251.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se262);
        se262.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se321);
        se321.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se322);
        se322.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se323);
        se323.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se331);
        se331.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se420);
        se420.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se422);
        se422.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se445);
        se445.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se491);
        se491.getGroupCourses().add(SEFOSMCRC);
        SEFOSMCRC.getCourses().add(se499);
        se499.getGroupCourses().add(SEFOSMCRC);

        //Field of Specialization | Major Courses | Free Elective
        SEFOSMCFE.getCourses().add(se324);
        se324.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se325);
        se325.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se326);
        se326.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se327);
        se327.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se351);
        se351.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se352);
        se352.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se362);
        se362.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se363);
        se363.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se411);
        se411.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se423);
        se423.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se424);
        se424.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se441);
        se441.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se442);
        se442.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se444);
        se444.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se452);
        se452.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se453);
        se453.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se463);
        se463.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se464);
        se464.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se465);
        se465.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se471);
        se471.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se472);
        se472.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se481);
        se481.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se482);
        se482.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se492);
        se492.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se493);
        se493.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se494);
        se494.getGroupCourses().add(SEFOSMCFE);
        SEFOSMCFE.getCourses().add(se495);
        se495.getGroupCourses().add(SEFOSMCFE);

        //Free Electives


        SE.getStandardStudyPlans().add(SEY1S1);
        SEY1S1.setPrograms(SE);
        SEY1S1.getCourses().add(ENGL101);
        ENGL101.getStandardStudyPlans().add(SEY1S1);
        SEY1S1.getCourses().add(math113);
        math113.getStandardStudyPlans().add(SEY1S1);
        SEY1S1.getCourses().add(se100);
        se100.getStandardStudyPlans().add(SEY1S1);
        SEY1S1.getCourses().add(atge102);
        atge102.getStandardStudyPlans().add(SEY1S1);
        SEY1S1.getCourses().add(atge103);
        atge103.getStandardStudyPlans().add(SEY1S1);




        DII.getGroupCourses().add(GEDII);
        GEDII.setPrograms(DII);
        DII.getStandardStudyPlans().add(DIIY1S1);
        DIIY1S1.setPrograms(DII);
        DII.getGroupCourses().add(FOSCCDII);
        FOSCCDII.setPrograms(DII);
        FOSCCDII.getCourses().add(ENGL102);
        ENGL102.getGroupCourses().add(FOSCCDII);


        GEDII.getCourses().add(ENGL101);
        ENGL101.getGroupCourses().add(GEDII);



        DIIY1S1.getCourses().add(se211);
        se211.getStandardStudyPlans().add(DIIY1S1);
    }
}
