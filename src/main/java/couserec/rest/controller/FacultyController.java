package couserec.rest.controller;

import couserec.rest.entity.Faculty;

import couserec.rest.service.FacultyService;


import couserec.rest.util.LabMapper;
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
        return ResponseEntity.ok(LabMapper.INSTANCE.getFacultyDto(addFaculty));
    }
    @GetMapping("/facultys")
    public ResponseEntity<?> getFacultys(){
        List<Faculty> getFaculty = facultyService.getFacultys();
        return ResponseEntity.ok(LabMapper.INSTANCE.getFacultyDto(getFaculty));
    }
    @GetMapping("/facultyById/{id}")
    public ResponseEntity<?> getFacultyById(@PathVariable int id){
        Faculty getFacultyById = facultyService.getFacultyById(id);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFacultyDto(getFacultyById));
    }
    @GetMapping("/facultyByFacultyId/{facultyId}")
    public ResponseEntity<?> getByFacultyId(@PathVariable String facultyId){
        Faculty getFacultyByFacultyId = facultyService.getFacultyByFacultyId(facultyId);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFacultyDto(getFacultyByFacultyId));
    }
    @PutMapping("/updateFaculty")
    public ResponseEntity<?> updateFaculty(@RequestBody Faculty faculty) {


        // Save the update faculty
        Faculty updateFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFacultyDto(updateFaculty));
    }
    @DeleteMapping("/deleteFaculty/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable int id) {
        String deleteFaculty = facultyService.deleteFaculty(id);
        return ResponseEntity.ok(deleteFaculty);
    }

}
