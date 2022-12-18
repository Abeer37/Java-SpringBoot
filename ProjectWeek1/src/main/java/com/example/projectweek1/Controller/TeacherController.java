package com.example.projectweek1.Controller;

import com.example.projectweek1.Model.Student;
import com.example.projectweek1.Model.Teacher;
import com.example.projectweek1.Service.StudentService;
import com.example.projectweek1.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    TeacherService teacherService;
    public TeacherController(TeacherService teacherService){
        this.teacherService=teacherService;
    }
    @GetMapping("/teacher")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Error errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added succssufly"));
    }
    @PutMapping ("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int ID, @RequestBody@Valid Teacher student,Error errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=teacherService.set(ID,teacher);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher is udated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not exist"));
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int ID,Error errors){
        if(errors.haserrors(){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isDeleted=teacherService.deleteTeacher(ID);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not exist"));
    }
}