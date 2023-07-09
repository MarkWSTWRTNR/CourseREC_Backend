package couserec.rest.controller;

import couserec.rest.entity.Faculty;
import couserec.rest.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @PostMapping("/addFaculty")
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.saveFaculty(faculty);
    }
    @PostMapping("/addFacultys")
    public List<Faculty> addFacultys(@RequestBody List<Faculty> facultys){
        return facultyService.saveFacultys(facultys);
    }
    @GetMapping("/facultys")
    public List<Faculty> findAllFacultys(){
        return facultyService.getFacultys();
    }
    @GetMapping("/facultyById/{id}")
    public Faculty findFacultyById(@PathVariable int id){
        return facultyService.getFacultyById(id);
    }
    @GetMapping("/facultysByFacultyId/{facultyId}")
    public  Faculty findFacultyByFacultyId(@PathVariable Integer facultyId){
        return facultyService.getFacultyByFacultyId(facultyId);
    }
    @GetMapping("/facultysByName/{name}")
    public Faculty findFacultyByName(@PathVariable String name){
        return facultyService.getFacultyByName(name);
    }
    @PutMapping("/updateFaculty")
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty);
    }
    @DeleteMapping("/deleteFaculty/{facultyId}")
    public String deleteFaculty(@PathVariable Integer facultyId){
        boolean deleted = facultyService.deleteFacultyById(facultyId);
        if (deleted) {
            return "Faculty deleted successfully";
        } else {
            return "Faculty not found";
        }
    }
}
