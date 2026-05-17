package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.services.EnrollmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {
    private EnrollmenService enrollmenService;

    @Autowired
    public EnrollmentController(EnrollmenService enrollmenService) {
        this.enrollmenService = enrollmenService;
    }
}
