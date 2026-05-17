package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private List<Course> courseList = new ArrayList<>();

    public CourseRepo() {
        courseList.add(new Course(1L, "Lập trình Java", "Open", 1L));
        courseList.add(new Course(2L, "Lập trình ReactJS", "Open", 2L));
    }
}
