package couserec.rest.dao;

import couserec.rest.entity.FinishedGroupCourse;
import couserec.rest.repository.FinishedGroupCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("db")
public class FinishedGroupGroupCourseDaoDbImpl implements FinishedGroupCourseDao {

    @Autowired
    FinishedGroupCourseRepository finishedGroupCourseRepository;

    @Override
    public FinishedGroupCourse saveFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse){
        return finishedGroupCourseRepository.save(finishedGroupCourse);
    }
    @Override
    public List<FinishedGroupCourse> getFinishedGroupCourse(){
        return finishedGroupCourseRepository.findAll();
    }
    @Override
    public FinishedGroupCourse updateFinishedGroupCourse(FinishedGroupCourse finishedGroupCourse){
        return finishedGroupCourseRepository.save(finishedGroupCourse);
    }
    @Override
    public FinishedGroupCourse getFinishedGroupCourseById(int id) {
        return finishedGroupCourseRepository.findById(id).orElse(null);
    }
    @Override
    public String deleteFinishedGroupCourse(int id){
        finishedGroupCourseRepository.deleteById(id);
        return "FinishedGroupCourse removed !!" + id;
    }
}
