package com.example.projectweek1.Controller;
import com.example.projectweek1.Model.Student;
import com.example.projectweek1.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping("/student")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(200).body(studentService.getStudent());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Error errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudents(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added succssufly"));
    }
    @PutMapping ("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int ID, @RequestBody@Valid Student student,Error errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=studentService.set(ID,student);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Student is udated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not exist or student not found"));
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int ID,Error errors){
        if(errors.haserrors(){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isDeleted=studentService.deleteStudent(ID);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not exist"));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getStudentID(@PathVariable int ID){
        String student=studentService.getStudentID(ID);
        if(student!=null) {
            return ResponseEntity.status(200).body(student);
        }
        return ResponseEntity.status(400).body("Student not found");
    }
    @GetMapping("/get/name")
    public ResponseEntity getStudentName(@RequestBody String name){
        String student=studentService.getStudentName(name);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/get/major")
    public ResponseEntity getStudentMajor(@RequestBody String major){
        String student=studentService.getStudentName(major);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/get/age")
    public ResponseEntity getStudentMajor(@RequestBody String age){
            String student = studentService.getStudentName(age);
            return ResponseEntity.status(200).body(student);
        }
    }
}


