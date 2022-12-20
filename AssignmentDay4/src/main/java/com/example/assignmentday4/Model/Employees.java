package com.example.assignmentday4.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Employees {
    @NotEmpty(message="ID can not be null")
    @Size(min=2,message=("ID length must be more than two"))
    public String ID;
    @NotEmpty(message="name can not be null")
    @Size(min=4,message=("name size must be more than four"))
    public String name;
    @NotNull(message="age can not be null")
    @Min(value=26,message="age must be more than 25")
    public String age;
    @AssertFalse(message="onelave must be false")
    public String onLeave;
    @NotNull(message="employee year can not be null")
    @Min(value=2000,message="employee year must be more than 2000")
    @Max(value=2024,message="employee year must be less than 2024")
    public String employmentYear;
    @NotNull(message="anualleave can not be null ")
    @Positive(message="annualleave must int anuual leave")
    public String annualLeave;
}

