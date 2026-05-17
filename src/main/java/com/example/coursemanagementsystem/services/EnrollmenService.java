package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.repositories.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmenService {
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    public EnrollmenService(EnrollmentRepo enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }
}
