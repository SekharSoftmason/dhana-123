package com.example.Rajesh.StudentManagementSystem.controller;

import com.example.Rajesh.StudentManagementSystem.controller.model.Student;
import com.example.Rajesh.StudentManagementSystem.controller.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return service.getAllStudent();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public  void addStudent(@RequestBody Student stud) {
        service.addStudent(stud);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student stud) {

        return service.updateStudent(id,stud);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);

    }
    @GetMapping("/students/pages")
    public Page<Student> pageAllStudent(@RequestParam int page, @RequestParam int size
            , @RequestParam String sortBy, @RequestParam String Direction) {
        return  service.pageAllStudent(page, size,sortBy,Direction);
    }
}
