package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.models.ApiResponse;
import com.example.coursemanagementsystem.models.Instructor;
import com.example.coursemanagementsystem.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors() {
        //return ResponseEntity.ok(instructorService.getAllInstructors());
        ApiResponse<List<Instructor>> response = new ApiResponse<>(true,"Lấy danh sách giảng viên thành công!",instructorService.getAllInstructors());
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getInstructorById(@PathVariable Long id) {
//        Instructor x = instructorService.getInstructorById(id);
//
//        if (x == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor không tìm thấy");
//        }
//
//        return ResponseEntity.ok(x);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getInstructorById(@PathVariable Long id) {
        try {
            Instructor x = instructorService.getInstructorById(id);

            if (x == null) {
                ApiResponse<?> response = new ApiResponse<>(false,"Instructor không tìm thấy",null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            ApiResponse<Instructor> response = new ApiResponse<>(true,"Lấy giảng viên theo Id thành công!",x);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<?> response = new ApiResponse<>(false,e.getMessage(),null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

//    @PostMapping
//    public ResponseEntity<?> createInstructor(@RequestBody Instructor instructor) {
//        Instructor x = instructorService.getInstructorById(instructor.getId());
//
//        if (x != null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Instructor Id đã tồn tại");
//        }
//
//        Instructor newInstructor = instructorService.createInstructor(instructor);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newInstructor);
//    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createInstructor(@RequestBody Instructor instructor) {
        Instructor x = instructorService.getInstructorById(instructor.getId());

        if (x != null) {
            ApiResponse<?> response =new ApiResponse<>(false,"Instructor Id đã tồn tại!",x);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Instructor newInstructor = instructorService.createInstructor(instructor);
        ApiResponse<?> response =new ApiResponse<>(true,"Tạo giảng viêng thành công!",newInstructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
//        Instructor x = instructorService.updateInstructor(id, instructor);
//
//        if (x == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor không tìm thấy");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(x);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        try {
            Instructor x = instructorService.updateInstructor(id, instructor);

            if (x == null) {
                ApiResponse<?> response =new ApiResponse<>(false,"Instructor không tìm thấy!",null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            ApiResponse<?> response =new ApiResponse<>(true,"Cập nhật giảng viên thành công!",x);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            ApiResponse<?> response = new ApiResponse<>(false,e.getMessage(),null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteInstructorById(@PathVariable Long id) {
//        Instructor x = instructorService.deleteInstructorById(id);
//        if (x == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor không tìm thấy");
//        }
//
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructorById(@PathVariable Long id) {
        try {
            Instructor x = instructorService.deleteInstructorById(id);
            if (x == null) {
                ApiResponse<?> response =new ApiResponse<>(false,"Instructor không tìm thấy!",null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            ApiResponse<?> response =new ApiResponse<>(true,"Xóa giảng viên thành công!",x);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            ApiResponse<?> response = new ApiResponse<>(false,e.getMessage(),null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
