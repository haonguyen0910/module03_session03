package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.models.Course;
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

    public List<Enrollment> findAll() {
        return enrollmentList;
    }

    public Enrollment findById(Long id) {
        for (Enrollment x : enrollmentList) {
            if(x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public Enrollment create(Enrollment enrollment) {
        enrollmentList.add(enrollment);
        return enrollment;
    }

    public Enrollment update(Long id, Enrollment enrollment) {
        for (Enrollment x : enrollmentList) {
            if(x.getId() == id) {
                x.setStudentName(enrollment.getStudentName());
                x.setCourseId(enrollment.getCourseId());
                return x;
            }
        }
        return null;
    }

    public Enrollment deleteById(Long id) {
        Enrollment x = findById(id);

        if (x != null) {
            enrollmentList.remove(x);
        }
        return x;
    }
}
