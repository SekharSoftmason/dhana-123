package com.example.Rajesh.StudentManagementSystem.configuration;

import com.example.Rajesh.StudentManagementSystem.Exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
       @ExceptionHandler(StudentNotFoundException.class)
       public ResponseGlobal<?> handlerStudentNotFoundException(StudentNotFoundException ex) {
             return ResponseGlobal.onError(ex.getMessage());
       }
}
