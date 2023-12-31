package couserec.rest.controller;

import couserec.rest.entity.Faculty;

import couserec.rest.service.FacultyService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @PostMapping("/addFaculty")
    public ResponseEntity<?> addFaculty(@RequestBody Faculty faculty) {
        Faculty addFaculty = facultyService.saveFaculty(faculty);
        return ResponseEntity.ok(addFaculty);
    }
    @GetMapping("/facultys")
    public ResponseEntity<?> getFacultys(){
        List<Faculty> getFaculty = facultyService.getFacultys();
        return ResponseEntity.ok(getFaculty);
    }
    @GetMapping("/facultyById/{id}")
    public ResponseEntity<?> getFacultyById(@PathVariable int id){
        Faculty getFacultyById = facultyService.getFacultyById(id);
        return ResponseEntity.ok(getFacultyById);
    }
    @GetMapping("/facultyByFacultyId/{courseId}")
    public ResponseEntity<?> getByFacultyId(@PathVariable String facultyId){
        Faculty getFacultyByFacultyId = facultyService.getFacultyByFacultyId(facultyId);
        return ResponseEntity.ok(getFacultyByFacultyId);
    }
    @PutMapping("/updateFaculty")
    public ResponseEntity<?> updateFaculty(@RequestBody Faculty faculty) {


        // Save the update faculty
        Faculty updateFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(updateFaculty);
    }
    @DeleteMapping("/deleteFaculty/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable int id) {
        String deleteFaculty = facultyService.deleteFaculty(id);
        return ResponseEntity.ok(deleteFaculty);
    }

}
