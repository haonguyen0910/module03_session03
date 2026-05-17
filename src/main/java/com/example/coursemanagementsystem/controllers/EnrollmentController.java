package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.models.ApiResponse;
import com.example.coursemanagementsystem.models.Enrollment;
import com.example.coursemanagementsystem.services.EnrollmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private EnrollmenService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmenService enrollmenService) {
        this.enrollmentService = enrollmenService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments() {
        //return ResponseEntity.ok(enrollmentService.getAllEnrollments());
        ApiResponse<List<Enrollment>> response = new ApiResponse<>(true,"Lấy danh sách nhập học thành công!",enrollmentService.getAllEnrollments());
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getEnrollmentById(@PathVariable Long id) {
//        Enrollment x = enrollmentService.getEnrollmentById(id);
//
//        if (x == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment không tìm thấy");
//        }
//
//        return ResponseEntity.ok(x);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getEnrollmentById(@PathVariable Long id) {
        Enrollment x = enrollmentService.getEnrollmentById(id);

        if (x == null) {
            ApiResponse<?> response = new ApiResponse<>(false,"Enrollment không tìm thấy",null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        ApiResponse<Enrollment> response = new ApiResponse<>(true,"Lấy nhập học theo Id thành công!",x);

        return ResponseEntity.ok(response);
    }


//    @PostMapping
//    public ResponseEntity<?> createEnrollment(@RequestBody Enrollment enrollment) {
//        Enrollment x = enrollmentService.getEnrollmentById(enrollment.getId());
//
//        if (x != null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enrollment Id đã tồn tại");
//        }
//
//        Enrollment newEnrollment = enrollmentService.createEnrollment(enrollment);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newEnrollment);
//    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment x = enrollmentService.getEnrollmentById(enrollment.getId());

        if (x != null) {
            ApiResponse<?> response =new ApiResponse<>(false,"Enrollment Id đã tồn tại!",x);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Enrollment newEnrollment = enrollmentService.createEnrollment(enrollment);
        ApiResponse<?> response =new ApiResponse<>(true,"Tạo nhập học thành công!",newEnrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
//        Enrollment x = enrollmentService.updateEnrollment(id, enrollment);
//
//        if (x == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment không tìm thấy");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(x);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        Enrollment x = enrollmentService.updateEnrollment(id, enrollment);

        if (x == null) {
            ApiResponse<?> response =new ApiResponse<>(false,"Enrollment không tìm thấy!",null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        ApiResponse<?> response =new ApiResponse<>(true,"Cập nhật nhập học thành công!",x);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteEnrollmentById(@PathVariable Long id) {
//        Enrollment x = enrollmentService.deleteEnrollmentById(id);
//        if (x == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment không tìm thấy");
//        }
//
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnrollmentById(@PathVariable Long id) {
        Enrollment x = enrollmentService.deleteEnrollmentById(id);
        if (x == null) {
            ApiResponse<?> response =new ApiResponse<>(false,"Enrollment không tìm thấy!",null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        ApiResponse<?> response =new ApiResponse<>(true,"Xóa nhập học thành công!",x);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
