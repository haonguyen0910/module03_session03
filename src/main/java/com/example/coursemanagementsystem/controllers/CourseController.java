package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.models.Course;
import com.example.coursemanagementsystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        Course x = courseService.getCourseById(id);

        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course không tìm thấy");
        }

        return ResponseEntity.ok(x);
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        Course x = courseService.getCourseById(course.getId());

        if (x != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course Id đã tồn tại");
        }

        Course newCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course x = courseService.updateCourse(id, course);

        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course không tìm thấy");
        }

        return ResponseEntity.status(HttpStatus.OK).body(x);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Long id) {
        Course x = courseService.deleteCourseById(id);
        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course không tìm thấy");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
