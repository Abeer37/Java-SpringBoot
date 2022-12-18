package com.example.projectweek1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.naming.Name;
@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message="Should not be empty")
    private int ID;
    @NotEmpty(message="Should not be empty")

    private String Name;
    @NotEmpty(message="Should not be empty")

    private int Age;
    @NotEmpty(message="Should not be empty")
    @Pattern(regexp = "cs,Math,Engineer")
    private String Major;
}
