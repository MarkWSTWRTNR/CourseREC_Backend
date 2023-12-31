package couserec.rest.controller;

import couserec.rest.entity.Faculty;
import couserec.rest.entity.Program;

import couserec.rest.repository.FacultyRepository;
import couserec.rest.repository.ProgramRepository;
import couserec.rest.service.ProgramService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgramController {
    @Autowired
    private ProgramService programService;
    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private FacultyRepository facultyRepository;

    @PostMapping("/addProgram")
    public ResponseEntity<?> addProgram(@RequestBody Program program) {

        Program addProgram = programService.saveProgram(program);
        return ResponseEntity.ok(addProgram);
    }
    @GetMapping("/programs")
    public ResponseEntity<?> getPrograms(){
        List<Program> getProgram = programService.getPrograms();
        return ResponseEntity.ok(getProgram);
    }
    @GetMapping("/programById/{id}")
    public ResponseEntity<?> getProgramById(@PathVariable int id){
        Program getProgramById = programService.getProgramById(id);
        return ResponseEntity.ok(getProgramById);
    }
    @GetMapping("/programByProgramId")
    public ResponseEntity<?> getProgramByProgramId(@PathVariable String programId){
        Program getProgramByProgramId = programService.getProgramByProgramId(programId);
        return ResponseEntity.ok(getProgramByProgramId);
    }
    @PutMapping("/updateProgram")
    public ResponseEntity<?> updateProgram(@RequestBody Program program) {
        // Save the update program
        Program updateProgram = programService.updateProgram(program);
        return ResponseEntity.ok(updateProgram);
    }
    @DeleteMapping("/deleteProgram/{id}")
    public ResponseEntity<?> deleteProgram(@PathVariable int id) {
        String deleteProgram = programService.deleteProgram(id);
        return ResponseEntity.ok(deleteProgram);
    }
    @PostMapping("/setProgramToFaculty")
    public ResponseEntity<?> setProgramToFaculty(@PathVariable Program program){
        Program program1 = programRepository.findById(program.getId()).orElse(null);
        Faculty faculty = facultyRepository.findById(program.getFaculty().getId()).orElse(null);
        program1.setFaculty(faculty);
        faculty.getPrograms().add(program1);
        return ResponseEntity.ok(program);
    }

}
