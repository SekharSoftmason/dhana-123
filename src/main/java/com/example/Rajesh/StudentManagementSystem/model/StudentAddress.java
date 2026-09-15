package com.example.Rajesh.StudentManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StudentAddress {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private  int id;
       private String state;
       private String city;
       private int pin_code;


}
