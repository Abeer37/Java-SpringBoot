package com.example.assigmentday7.Controller;

import com.example.assigmentday7.Dto.ApiResponse;
import com.example.assigmentday7.Model.User;
import com.example.assigmentday7.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> user=userService.getUser();
        return ResponseEntity.status(200).body(user);
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added!!"));
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody@Valid User user,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("user update!!"));
    }
    @DeleteMapping("/delet/{index}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "user delete";
    }
}
