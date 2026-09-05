package com.example.Rajesh.service;

import com.example.Rajesh.Repo.StudentRepo;
import com.example.Rajesh.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;
    public List<Student> getAllStudent() {
        return repo.findAll();
    }
    public Student getStudentById(int id) {
        return repo.findById(id).
                orElseThrow(()->new RuntimeException("student Not Found"+id));

    }
    public void addStudent(Student stud) {
        repo.save(stud);
    }
    public Student updateStudent(int id, Student stud) {
        Student existingStudent = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setAge(stud.getAge());
        existingStudent.setStudentName(stud.getStudentName());
        existingStudent.setCollegeName(stud.getCollegeName());

        return repo.save(existingStudent);
    }
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
    public Page<Student> pageAllStudent(int page, int size, String sortBy, String Direction) {
        Sort sort;
        if (Direction.equalsIgnoreCase("desc")) {
            sort=Sort.by(sortBy).descending();
        }
        else {
            sort=Sort.by(sortBy).ascending();
        }
        return repo.findAll(PageRequest.of(page,size,sort));
    }
}
