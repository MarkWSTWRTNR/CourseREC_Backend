package couserec.rest.controller;

import couserec.rest.entity.Program;

import couserec.rest.service.ProgramService;


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
    @PutMapping("/updateProgram")
    public ResponseEntity<?> updateProgram(@RequestBody Program program) {




        // Save the update program
        Program updateProgram = programService.updateProgram(program);
        return ResponseEntity.ok(updateProgram);
    }
    @DeleteMapping("/deleteProgram/{id}")
    public ResponseEntity<String> deleteProgram(@PathVariable int id) {
        String deleteProgram = programService.deleteProgram(id);
        return ResponseEntity.ok(deleteProgram);
    }

}
