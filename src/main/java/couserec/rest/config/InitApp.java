package couserec.rest.config;

import couserec.rest.entity.Course;
import couserec.rest.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    CourseRepository courseRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Course a = courseRepository.save(
                Course.builder()
                        .courseId("953331").name("A").build()
        );
        a.setName("hello");
        Course b = courseRepository.save(
                Course.builder().courseId("001001").name("Eng").build()
        );
        b.getPrerequisite().add(a);
    }
}
