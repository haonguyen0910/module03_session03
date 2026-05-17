package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.models.ApiResponse;
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
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
//        return ResponseEntity.ok(courseService.getAllCourses());
        ApiResponse<List<Course>> response = new ApiResponse<>(true,"Lấy danh sách khóa học thành công!",courseService.getAllCourses());
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
//        Course x = courseService.getCourseById(id);
//
//        if (x == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course không tìm thấy");
//        }
//
//        return ResponseEntity.ok(x);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getCourseById(@PathVariable Long id) {
        try {
            Course x = courseService.getCourseById(id);

            if (x == null) {
                ApiResponse<?> response = new ApiResponse<>(false,"Course không tìm thấy",null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            ApiResponse<Course> response = new ApiResponse<>(true,"Lấy khóa học thành công!",x);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<?> response = new ApiResponse<>(false,e.getMessage(),null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

//    @PostMapping
//    public ResponseEntity<?> createCourse(@RequestBody Course course) {
//        Course x = courseService.getCourseById(course.getId());
//
//        if (x != null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course Id đã tồn tại");
//        }
//
//        Course newCourse = courseService.createCourse(course);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newCourse);
//    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createCourse(@RequestBody Course course) {
        Course x = courseService.getCourseById(course.getId());

        if (x != null) {
            ApiResponse<?> response =new ApiResponse<>(false,"Course Id đã tồn tại!",x);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Course newCourse = courseService.createCourse(course);
        ApiResponse<?> response =new ApiResponse<>(true,"Tạo khóa học thành công!",newCourse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course course) {
//        Course x = courseService.updateCourse(id, course);
//
//        if (x == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course không tìm thấy");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(x);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        try {
            Course x = courseService.updateCourse(id, course);

            if (x == null) {
                ApiResponse<?> response =new ApiResponse<>(false,"Course không tìm thấy!",null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            ApiResponse<?> response =new ApiResponse<>(true,"Cập nhật khóa học thành công!",x);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            ApiResponse<?> response = new ApiResponse<>(false,e.getMessage(),null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCourseById(@PathVariable Long id) {
//        Course x = courseService.deleteCourseById(id);
//        if (x == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course không tìm thấy");
//        }
//
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Long id) {
        try {
            Course x = courseService.deleteCourseById(id);
            if (x == null) {
                ApiResponse<?> response =new ApiResponse<>(false,"Course không tìm thấy!",null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            ApiResponse<?> response =new ApiResponse<>(true,"Xóa khóa học thành công!",x);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            ApiResponse<?> response = new ApiResponse<>(false,e.getMessage(),null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
