package com.example.assigmentday7.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @NotNull(message = "ID Cannot be null")
    @Id
    private Integer ID;
    @NotEmpty(message = "Cannot be null")
    @Size(min=5,message ="Length more than 4")
    private String name;
    @Size(min=5,message ="Length more than 4")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @Column(columnDefinition = "varchar(30) not null unique")
    @Email(message = "must be valid email" )
    private String email;
    @NotEmpty(message = "Cannot be null")
    @Column(columnDefinition = "varchar(5) check('user'or'admin')")
    private String role;
    @NotEmpty(message = "Cannot be null")
    @Column(columnDefinition = "varchar(2) Integer")
    private Integer age;
}

