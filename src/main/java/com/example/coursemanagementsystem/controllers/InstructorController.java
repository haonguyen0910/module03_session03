package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.models.Enrollment;
import com.example.coursemanagementsystem.models.Instructor;
import com.example.coursemanagementsystem.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable Long id) {
        Instructor x = instructorService.getInstructorById(id);

        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor không tìm thấy");
        }

        return ResponseEntity.ok(x);
    }

    @PostMapping
    public ResponseEntity<?> createInstructor(@RequestBody Instructor instructor) {
        Instructor x = instructorService.getInstructorById(instructor.getId());

        if (x != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Instructor Id đã tồn tại");
        }

        Instructor newInstructor = instructorService.createInstructor(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newInstructor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        Instructor x = instructorService.updateInstructor(id, instructor);

        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor không tìm thấy");
        }

        return ResponseEntity.status(HttpStatus.OK).body(x);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructorById(@PathVariable Long id) {
        Instructor x = instructorService.deleteInstructorById(id);
        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor không tìm thấy");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
