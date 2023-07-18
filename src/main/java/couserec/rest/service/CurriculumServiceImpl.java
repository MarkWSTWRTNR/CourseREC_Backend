package couserec.rest.service;

import couserec.rest.dao.CourseDao;
import couserec.rest.dao.CurriculumDao;
import couserec.rest.entity.Course;
import couserec.rest.entity.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CurriculumServiceImpl implements CurriculumService{
    @Autowired
    CurriculumDao curriculumDao;

    CourseDao courseDao;

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

    @Transactional
    public Curriculum addCourseToCurriculum(int courseId,int currilumId,String group){
       Curriculum c =  curriculumDao.getCurriculumById(currilumId);
        Course co = courseDao.getCourseById(courseId);
        if (group.equals("abc")){
            c.getFoscc().add(co);
            co.getCurriculum().add(c);
            return c;
        }
        return null;
    }

}
