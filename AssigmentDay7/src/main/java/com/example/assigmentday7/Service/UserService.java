package com.example.assigmentday7.Service;

import com.example.assigmentday7.Model.User;
import com.example.assigmentday7.Repostry.UserRepoistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepoistry userRepoistry;

    public List<User> getUser(){
        return userRepoistry.findAll();
    }
    public void addUser(User user){
        userRepoistry.save(user);
    }
    public Boolean updateUser(Integer id,User user){
        User olduser=userRepoistry.getById(id);
        if(olduser==null){
            return false;
        }
        olduser.setName(user.getName());
        olduser.setUsername(user.getUsername());
        olduser.setPassword(user.getPassword());
        olduser.setEmail(user.getEmail());
        olduser.setRole(user.getRole());
        olduser.setAge(user.getAge());
        userRepoistry.save(olduser);
        return true;
    }
    public Boolean deleteUser(Integer id){
        User user=userRepoistry.getById(id);
        if(user==null){
            return false;
        }
        userRepoistry.delete(user);
        return true;
    }
}
