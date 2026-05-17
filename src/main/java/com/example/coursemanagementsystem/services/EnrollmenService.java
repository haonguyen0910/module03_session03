package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.models.Enrollment;
import com.example.coursemanagementsystem.repositories.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmenService {
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    public EnrollmenService(EnrollmentRepo enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepo.findById(id);
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepo.create(enrollment);
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        return enrollmentRepo.update(id, enrollment);
    }

    public Enrollment deleteEnrollmentById(Long id) {
        return enrollmentRepo.deleteById(id);
    }
}
