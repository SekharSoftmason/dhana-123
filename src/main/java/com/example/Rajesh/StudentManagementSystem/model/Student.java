package com.example.Rajesh.StudentManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private  int age;
    private String studentName;
    private String collegeName;
    private String email;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="address_id", referencedColumnName ="id" )
    private StudentAddress address;
}
