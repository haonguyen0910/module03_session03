package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.models.Course;
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
    public List<Instructor> findAll() {
        return instructorList;
    }

    public Instructor findById(Long id) {
        for (Instructor x : instructorList) {
            if(x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public Instructor create(Instructor instructor) {
        instructorList.add(instructor);
        return instructor;
    }

    public Instructor update(Long id, Instructor instructor) {
        for (Instructor x : instructorList) {
            if(x.getId() == id) {
                x.setName(instructor.getName());
                x.setEmail(instructor.getEmail());
                return x;
            }
        }
        return null;
    }

    public Instructor deleteById(Long id) {
        Instructor x = findById(id);
        if (x != null) {
            instructorList.remove(x);
        }
        return x;
    }
}
