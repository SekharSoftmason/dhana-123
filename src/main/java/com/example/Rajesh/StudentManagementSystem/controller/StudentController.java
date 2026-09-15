package com.example.Rajesh.StudentManagementSystem.controller;

import com.example.Rajesh.StudentManagementSystem.configuration.ResponseGlobal;
import com.example.Rajesh.StudentManagementSystem.model.Student;
import com.example.Rajesh.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/getAllStudent")
    public ResponseGlobal<List<Student>> getAllStudent() {
        return service.getAllStudent();
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseGlobal<Student> getStudentById(@PathVariable int id)
    {
        return service.getStudentById(id);
    }

    @PostMapping("/addStudent")
    public  ResponseGlobal<Student>  addStudent(@RequestBody Student stud) {
       return service.addStudent(stud);
    }
    @PutMapping("/updateStudent/{id}")
    public ResponseGlobal<Student>  updateStudent(@PathVariable int id, @RequestBody Student stud) {


        return service.updateStudent(id,stud);
    }
    @DeleteMapping("deleteStudent/{id}")
    public ResponseGlobal<Student>  deleteStudent(@PathVariable int id) {
         return service.deleteStudent(id);

    }
    @GetMapping("/pagination")
    public ResponseGlobal<Page<Student>> pageAllStudent(@RequestParam int page, @RequestParam int size
            , @RequestParam String sortBy, @RequestParam String Direction) {
        return  service.pageAllStudent(page, size,sortBy,Direction);
    }
}
