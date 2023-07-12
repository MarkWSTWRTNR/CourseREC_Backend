package couserec.rest.controller;

import couserec.rest.entity.Curriculum;
import couserec.rest.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurriculumController {
    @Autowired
    CurriculumService curriculumService;

    @PostMapping("/addCurriculum")
    public ResponseEntity<?> addCurriculum(@RequestBody Curriculum curriculum){
        Curriculum addCurriculum = curriculumService.saveCurriculum(curriculum);
        return ResponseEntity.ok(addCurriculum);
    }

    @GetMapping("/curriculums")
    public ResponseEntity<?> getCurriculums( ){
        List<Curriculum> getCurriculums = curriculumService.getCurriculums();
        return ResponseEntity.ok(getCurriculums);
    }
}
