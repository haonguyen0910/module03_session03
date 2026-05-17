package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.models.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepo {
    private List<Instructor> instructorList = new ArrayList<>();

    public InstructorRepo() {
        instructorList.add(new Instructor(1L, "Nguyễn Văn An", "nguyenvanan@gmail.com"));
        instructorList.add(new Instructor(2L, "Trần Văn Bình", "tranvanbinh@gmail.com"));
    }
}
