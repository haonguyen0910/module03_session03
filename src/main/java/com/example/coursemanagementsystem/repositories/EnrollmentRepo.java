package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.models.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepo {
    private List<Enrollment> enrollmentList = new ArrayList<>();

    public EnrollmentRepo() {
        enrollmentList.add(new Enrollment(1L, "Hảo", 1L));
        enrollmentList.add(new Enrollment(2L, "Cường", 2L));
    }
}
