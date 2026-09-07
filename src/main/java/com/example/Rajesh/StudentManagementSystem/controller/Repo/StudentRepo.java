package com.example.Rajesh.StudentManagementSystem.controller.Repo;

import com.example.Rajesh.StudentManagementSystem.controller.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
