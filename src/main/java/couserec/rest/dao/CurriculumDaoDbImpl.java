package couserec.rest.dao;

import couserec.rest.entity.Curriculum;
import couserec.rest.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("db")
public class CurriculumDaoDbImpl implements CurriculumDao {
    @Autowired
    CurriculumRepository curriculumRepository;

   @Override
    public Curriculum saveCurriculum(Curriculum curriculum){
        return curriculumRepository.save(curriculum);
    }
    @Override
    public List<Curriculum> getCurriculums(){
       return curriculumRepository.findAll();
    }
    @Override
    public Curriculum getCurriculumById(int id){
       return curriculumRepository.findById(id).orElse(null);
    }
}
