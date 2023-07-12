package couserec.rest.service;

import couserec.rest.dao.CurriculumDao;
import couserec.rest.entity.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumServiceImpl implements CurriculumService{
    @Autowired
    CurriculumDao curriculumDao;

    @Override
    public Curriculum saveCurriculum(Curriculum curriculum){
        return curriculumDao.saveCurriculum(curriculum);
    }
    @Override
    public List<Curriculum> getCurriculums(){
        return curriculumDao.getCurriculums();
    }
    @Override
    public Curriculum getCurriculumById(int id){
        return curriculumDao.getCurriculumById(id);
    }
}
