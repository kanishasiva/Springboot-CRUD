package com.example.StudentCRUD.service;

import com.example.StudentCRUD.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Studentservice {

    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "John Doe", "Java"));
        students.add(new Student(2, "Jane Doe", "Python"));
    }

    public List<Student> getstu(){
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(1, "John Doe", "Java"));
//        students.add(new Student(2, "Jane Doe", "Python"));
        return students;
    }

    public Student getrolno(int rollno) {
        int ind =0;
        boolean flag = false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getRno() == rollno ){
                  ind=i;
                  flag=true;
            }
        }
        if(!flag) return new Student(0,"","");
        else{
            return students.get(ind);
        }
    }

    public void addstudent(Student student) {
        students.add(student);

    }

    public String updatestudent(Student student) {
        boolean flag = false;
        int ind =0;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getRno() == student.getRno() ){
                ind=i;
                flag = true;
                break;
            }
        }
        if(!flag) return "No such data available";
        else{
            students.set(ind,student);
            return "updated successfully..!";
        }
    }

    public String deletestudent(int rollno) {
        int ind =0;
        boolean flag = false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getRno() == rollno ){
                ind=i;
                flag = true;
            }
        }
        if(flag){
            students.remove(rollno);
            return "Deleted successfuly";
        }
        else{
            return "No such student";
        }
    }
}
