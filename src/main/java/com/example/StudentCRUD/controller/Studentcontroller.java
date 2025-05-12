package com.example.StudentCRUD.controller;

import com.example.StudentCRUD.model.Student;
import com.example.StudentCRUD.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Studentcontroller {

    @Autowired
    Studentservice studentservice ;

    @GetMapping("/student")
    public List<Student> getstudent(){
        return studentservice.getstu();
    }

    @GetMapping("/student/{rolno}")
    public Student getrolno(@PathVariable("rolno") int rollno){
        return studentservice.getrolno(rollno) ;
    }

    @PostMapping("/student")
    public String addstudent(@RequestBody Student student){
        studentservice.addstudent(student);
        return "Success";
    }

    @PutMapping("/student")
    public String updatestudent(@RequestBody Student student){
       return studentservice.updatestudent(student);
    }

    @DeleteMapping("/student/{rolno}")
    public String delete(@PathVariable("rolno") int rollno){
        return studentservice.deletestudent(rollno);
    }
}
