package com.example.projectweek1.Service;

import com.example.projectweek1.Model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Data@AllArgsConstructor
@Service
public class StudentService {
    ArrayList<Student>students=new ArrayList<>();
    public ArrayList<Student> getStudent() {
        return students;
    }
    public void addStudents(Student student){
        students.add(student);
    }
    public void updateStudent(int ID, Student student){
        students.set(ID,student);
    }
    public void isDeleted(int index){
        students.remove(index);
    }
}
