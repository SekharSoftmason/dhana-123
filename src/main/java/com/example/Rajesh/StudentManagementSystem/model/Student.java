package com.example.Rajesh.StudentManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Max(value=35)
    @NotNull
    private  int age;
    @NotBlank()
    @Size(min=3,max=12)
    private String studentName;
    @NotBlank
    @Size(min=3,max=12)
    private String collegeName;
    private float percentage;
    private boolean status;
    @Email
    private String email;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="address_id", referencedColumnName ="id" )
    private Address address;
}
