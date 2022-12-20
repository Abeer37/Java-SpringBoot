package com.example.assignmentday4.Controller;

import com.example.assignmentday4.ApiResponse;
import com.example.assignmentday4.Model.Employees;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1")
public class EmployeesController {
    ArrayList<Employees> employees =new ArrayList<>();
    @GetMapping("/Employee")
    public ArrayList<Employees> getEmployee(){
        return employees;
    }
    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody @Valid Employees employee,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee has been Added"));
    }
    @PostMapping("/update/{index}")
    public ResponseEntity updateEmployee(@PathVariable int index,@RequestBody Employees employee,@Valid Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.set(index,employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee has been Updated"));
    }
    @DeleteMapping("/Delete/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index, Errors errors){
        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Employee has been deleted"));
    }
}
