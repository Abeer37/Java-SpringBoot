package com.example.projectweek1.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotEmpty(message="Should not be empty")
    private int ID;
    @NotEmpty(message="Should not be empty")

    private String Name;
    @NotEmpty(message="Should not be empty")
    private String Salary;
}
