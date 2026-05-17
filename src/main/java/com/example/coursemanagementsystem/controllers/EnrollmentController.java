package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.models.Enrollment;
import com.example.coursemanagementsystem.services.EnrollmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private EnrollmenService enrollmenService;

    @Autowired
    public EnrollmentController(EnrollmenService enrollmenService) {
        this.enrollmenService = enrollmenService;
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmenService.getAllEnrollments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEnrollmentById(@PathVariable Long id) {
        Enrollment x = enrollmenService.getEnrollmentById(id);

        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment không tìm thấy");
        }

        return ResponseEntity.ok(x);
    }

    @PostMapping
    public ResponseEntity<?> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment x = enrollmenService.getEnrollmentById(enrollment.getId());

        if (x != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enrollment Id đã tồn tại");
        }

        Enrollment newEnrollment = enrollmenService.createEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEnrollment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        Enrollment x = enrollmenService.updateEnrollment(id, enrollment);

        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment không tìm thấy");
        }

        return ResponseEntity.status(HttpStatus.OK).body(x);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnrollmentById(@PathVariable Long id) {
        Enrollment x = enrollmenService.deleteEnrollmentById(id);
        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment không tìm thấy");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
