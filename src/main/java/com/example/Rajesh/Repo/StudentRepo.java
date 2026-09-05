package com.example.Rajesh.Repo;

import com.example.Rajesh.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
