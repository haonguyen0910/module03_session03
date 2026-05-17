package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {
    private List<Course> courseList = new ArrayList<>();

    public CourseRepo() {
        courseList.add(new Course(1L, "Lập trình Java", "Open", 1L));
        courseList.add(new Course(2L, "Lập trình ReactJS", "Open", 2L));
    }

    public List<Course> findAll() {
        return courseList;
    }

//    public Course findById(Long id) {
//        for (Course x : courseList) {
//            if(x.getId() == id) {
//                return x;
//            }
//        }
//        return null;
//    }

    public Optional<Course> findById(Long id) {
        return courseList.stream().filter(x -> x.getId().equals(id)).findFirst();
    }


    public Course create(Course course) {
        courseList.add(course);
        return course;
    }

//    public Course update(Long id, Course course) {
//        for (Course x : courseList) {
//            if(x.getId() == id) {
//                x.setTitle(course.getTitle());
//                x.setStatus(course.getStatus());
//                x.setInstructorId(course.getInstructorId());
//                return x;
//            }
//        }
//        return null;
//    }

    public Course update(Long id, Course course) {

        Course x = findById(id).orElseThrow(() -> new RuntimeException("Course không tìm thấy"));

        x.setTitle(course.getTitle());
        x.setStatus(course.getStatus());
        x.setInstructorId(course.getInstructorId());
        return x;
    }

//    public Course deleteById(Long id) {
//        Course x = findById(id);
//
//        if (x != null) {
//            courseList.remove(x);
//        }
//        return x;
//    }

    public Course deleteById(Long id) {
        Course x = findById(id).orElseThrow(() -> new RuntimeException("Course không tìm thấy"));
        courseList.remove(x);

        return x;
    }
}
