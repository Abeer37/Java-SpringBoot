package com.example.projectweek1.Service;

import com.example.projectweek1.Model.Student;
import com.example.projectweek1.Model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@Service
public class TeacherService {
    ArrayList<Student>teacher=new ArrayList<>();
    public ArrayList<Student> getTeacher() {
        return teacher;
    }
    public void addTeacher(Teacher teacher){
        teacher.add(teacher);
    }
    public void updateStudent(int ID, Teacher teacher){
        teacher.set(ID,teacher);
    }
    public void isDeleted(int index){
        teacher.remove(index);
    }
}