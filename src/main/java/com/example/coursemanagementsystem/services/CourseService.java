package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.models.Course;
import com.example.coursemanagementsystem.repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepo.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepo.create(course);
    }

    public Course updateCourse(Long id, Course course) {
        return courseRepo.update(id, course);
    }

    public Course deleteCourseById(Long id) {
        return courseRepo.deleteById(id);
    }

}
