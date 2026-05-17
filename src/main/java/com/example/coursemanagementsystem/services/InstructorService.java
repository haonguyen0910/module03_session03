package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.models.Instructor;
import com.example.coursemanagementsystem.repositories.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private InstructorRepo instructorRepo;

    @Autowired
    public InstructorService(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepo.findById(id);
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepo.create(instructor);
    }

    public Instructor updateInstructor(Long id, Instructor instructor) {
        return instructorRepo.update(id, instructor);
    }

    public Instructor deleteInstructorById(Long id) {
        return instructorRepo.deleteById(id);
    }



}
