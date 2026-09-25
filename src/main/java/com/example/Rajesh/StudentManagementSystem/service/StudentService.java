package com.example.Rajesh.StudentManagementSystem.service;

import com.example.Rajesh.StudentManagementSystem.Repo.StudentRepo;
import com.example.Rajesh.StudentManagementSystem.StudentDTO.StudentDto;
import com.example.Rajesh.StudentManagementSystem.configuration.ResponseGlobal;
import com.example.Rajesh.StudentManagementSystem.model.Student;
import com.example.Rajesh.StudentManagementSystem.model.Address;
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
    public ResponseGlobal<List<Student>> getAllStudent() {
        List <Student> students= repo.findAll();
        if (students.isEmpty()) {
            return ResponseGlobal.onFailure(
                    "No students found");
        }
        return ResponseGlobal.onSuccess("Student Fetched Sucessfully", repo.findAll());
    }
    public ResponseGlobal<Student> getStudentById(int id) {
        try {
            return ResponseGlobal.onSuccess("Student Fetched Successfully", repo.findById(id).
                    orElseThrow(() -> new RuntimeException("student Not Found" + id)));
        }
        catch (RuntimeException e) {
            throw new RuntimeException("Student not found with id: " + id);
        }

    }
    public ResponseGlobal<StudentDto> addStudent(StudentDto stud) {
          if (stud.getEmail()==null || stud.getEmail().isEmpty()) {
              return ResponseGlobal.onError("The Email is required");
          }
          Student existStudent= repo.findByEmail(stud.getEmail());
          System.out.println("This is requested Email"+stud.getEmail()+"And this is my Existing Email object return email");
          if (existStudent!=null) {
                return ResponseGlobal.onFailure("This Email is being attached with another student Email");
          }
          Student student =new Student();
          student.setAge(stud.getAge());
          student.setStudentName(stud.getStudentName());
          student.setCollegeName(stud.getCollegeName());
          student.setPercentage(stud.getPercentage());
          student.setEmail(stud.getEmail());
          student.setStatus(true);
          Address address=new Address();
          address.setCity(stud.getCity());
          address.setState(stud.getState());
         address.setPincode(stud.getPincode());
          student.setAddress(address);
          repo.save(student);
    return ResponseGlobal.onSuccess
                ("Student has been created Well" ,stud);
    }
    public ResponseGlobal<Student>  updateStudent(int id, Student stud) {
        Student existingStudent = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setAge(stud.getAge());
        existingStudent.setStudentName(stud.getStudentName());
        existingStudent.setCollegeName(stud.getCollegeName());
        existingStudent.setPercentage(stud.getPercentage());
        existingStudent.setEmail(stud.getEmail());
         return ResponseGlobal.onSuccess("Student updated Successfully",repo.save(existingStudent));
    }
    public String deleteStudent(int id) {
        if (!repo.existsById(id)) {
            return "Student not found" +id + "does not Exist";
        } {
            repo.deleteById(id);
            return "Student with id " + id + " has been deleted successfully.";
        }
    }
    public ResponseGlobal<Page<Student>> pageAllStudent(int page, int size, String sortBy, String Direction) {
        Sort sort;
        if (Direction.equalsIgnoreCase("desc")) {
            sort=Sort.by(sortBy).descending();
        }
        else {
            sort=Sort.by(sortBy).ascending();
        }
        return ResponseGlobal.onSuccess("PageStudent Fetched Successfully",repo.findAll(PageRequest.of(page,size,sort)));
    }
}
