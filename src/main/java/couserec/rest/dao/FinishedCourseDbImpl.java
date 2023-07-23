package couserec.rest.dao;

import couserec.rest.entity.FinishedCourse;
import couserec.rest.repository.FinishedCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("db")
public class FinishedCourseDbImpl implements FinishedCourseDao {

    @Autowired
    FinishedCourseRepository finishedCourseRepository;

    @Override
    public FinishedCourse saveStudentFinishedCourse(FinishedCourse finishedCourse){
        return finishedCourseRepository.save(finishedCourse);
    }
    @Override
    public List<FinishedCourse> getStudentFinishedCourse(){
        return finishedCourseRepository.findAll();
    }
    @Override
    public FinishedCourse updateStudentFinishedCourse(FinishedCourse finishedCourse){
        return finishedCourseRepository.save(finishedCourse);
    }
    @Override
    public FinishedCourse getStudentFinishedCourseById(int id) {
        return finishedCourseRepository.findById(id).orElse(null);
    }

}
