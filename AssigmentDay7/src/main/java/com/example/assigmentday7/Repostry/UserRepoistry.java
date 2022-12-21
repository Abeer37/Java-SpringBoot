package com.example.assigmentday7.Repostry;

import com.example.assigmentday7.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepoistry extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    User findUserByName(String name);
    User findUserByUsername(String username);
}
