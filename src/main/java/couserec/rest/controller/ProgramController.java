package couserec.rest.controller;

import couserec.rest.entity.Faculty;
import couserec.rest.entity.Program;

import couserec.rest.repository.FacultyRepository;
import couserec.rest.repository.ProgramRepository;
import couserec.rest.service.ProgramService;


import couserec.rest.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @PostMapping("/addProgram")
    public ResponseEntity<?> addProgram(@RequestBody Program program) {
        Program addProgram = programService.saveProgram(program);
        return ResponseEntity.ok(LabMapper.INSTANCE.getProgramDto(addProgram));
    }
    @GetMapping("/programs")
    public ResponseEntity<?> getPrograms(){
        List<Program> getProgram = programService.getPrograms();
        return ResponseEntity.ok(LabMapper.INSTANCE.getProgramDto(getProgram));
    }
    @GetMapping("/programById/{id}")
    public ResponseEntity<?> getProgramById(@PathVariable int id){
        Program getProgramById = programService.getProgramById(id);
        return ResponseEntity.ok(LabMapper.INSTANCE.getProgramDto(getProgramById));
    }
    @GetMapping("/programByProgramId/{programId}")
    public ResponseEntity<?> getProgramByProgramId(@PathVariable String programId){
        Program getProgramByProgramId = programService.getProgramByProgramId(programId);
        return ResponseEntity.ok(LabMapper.INSTANCE.getProgramDto(getProgramByProgramId));
    }
    @PutMapping("/updateProgram")
    public ResponseEntity<?> updateProgram(@RequestBody Program program) {
        // Save the update program
        Program updateProgram = programService.updateProgram(program);
        return ResponseEntity.ok(LabMapper.INSTANCE.getProgramDto(updateProgram));
    }
    @DeleteMapping("/deleteProgram/{id}")
    public ResponseEntity<?> deleteProgram(@PathVariable int id) {
        String deleteProgram = programService.deleteProgram(id);
        return ResponseEntity.ok(deleteProgram);
    }
    @PutMapping("/addCourseToProgram")
    public ResponseEntity<?> addCourseToProgram(@RequestBody Program program) {
        Program addCourseToProgram = programService.addCourseToProgram(program);
        return ResponseEntity.ok(LabMapper.INSTANCE.getProgramDto(addCourseToProgram));
    }
    @PutMapping("/removeCourseFromProgram/{programId}/{sectionType}/{courseId}")
    public ResponseEntity<?> removeCourseFromProgram(@PathVariable String programId,@PathVariable String sectionType, @PathVariable String courseId) {
        Program removeCourseFromProgram = programService.removeCourseFromProgram(programId,sectionType, courseId);
        return ResponseEntity.ok(LabMapper.INSTANCE.getProgramDto(removeCourseFromProgram));
    }
    @PutMapping("/updateProgramCredits/{programId}")
    public ResponseEntity<?> updateProgramCredits(@PathVariable String programId, @RequestBody Program updatedProgram) {
        Program programWithUpdatedCredits = programService.updateProgramCredits(programId, updatedProgram);
        return ResponseEntity.ok(LabMapper.INSTANCE.getProgramDto(programWithUpdatedCredits));
    }
}
