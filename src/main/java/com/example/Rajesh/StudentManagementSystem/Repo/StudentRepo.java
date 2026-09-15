package com.example.Rajesh.StudentManagementSystem.Repo;

import com.example.Rajesh.StudentManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
       Student findByEmail(String email);
}
