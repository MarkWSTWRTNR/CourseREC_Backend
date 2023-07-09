package couserec.rest.controller;

import couserec.rest.entity.Program;
import couserec.rest.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @PostMapping("/addProgram")
    public Program addProgram(@RequestBody Program program) {
        return programService.saveProgram(program);
    }
    @PostMapping("/addPrograms")
    public List<Program> addPrograms(@RequestBody List<Program> programs){
        return programService.savePrograms(programs);
    }
    @GetMapping("/programs")
    public List<Program> findAllPrograms(){
        return programService.getPrograms();
    }
    @GetMapping("/programById/{id}")
    public Program findProgramById(@PathVariable int id){
        return programService.getProgramById(id);
    }
    @GetMapping("/programsByProgramId/{programId}")
    public  Program findProgramByProgramId(@PathVariable Integer programId){
        return programService.getProgramByProgramId(programId);
    }
    @GetMapping("/programsByName/{name}")
    public Program findProgramByName(@PathVariable String name){
        return programService.getProgramByName(name);
    }
    @PutMapping("/updateProgram")
    public Program updateProgram(@RequestBody Program program) {
        return programService.updateProgram(program);
    }
    @DeleteMapping("/deleteProgram/{programId}")
    public String deleteProgram(@PathVariable Integer programId){
        boolean deleted = programService.deleteProgramById(programId);
        if (deleted) {
            return "Program deleted successfully";
        } else {
            return "Program not found";
        }
    }
}
