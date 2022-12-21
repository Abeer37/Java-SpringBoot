package com.example.assigmentday7.Controller;

import com.example.assigmentday7.Dto.ApiResponse;
import com.example.assigmentday7.Model.User;
import com.example.assigmentday7.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addUser(@RequestBody@Valid User user){
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added!!"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody@Valid User user){
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("user update!!"));
    }
    @DeleteMapping("/delet/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "user delete";
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
        User user=userService.getUserById(id);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/bytitle/{name}")
    public ResponseEntity getUserByName(@PathVariable String name){
        User user=userService.getUserByName(name);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/bytitle/{username}")
    public ResponseEntity getUserByUsername(@PathVariable String username){
        User user=userService.getUserByUsername(username);
        return ResponseEntity.status(200).body(user);
    }

}
