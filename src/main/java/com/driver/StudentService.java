package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public String addTeacher(Teacher teacher){
        return studentRepository.addTeacher(teacher);
    }

    // 3
    public String addStudentTeacherPair(String student,String teacher){
        return studentRepository.addStudentTeacherPair(student,teacher);
    }

    // 4
    public Student getStudentByName(String student){
        return studentRepository.getStudentByName(student);
    }

    // 5
    public Teacher getTeacherByName(String teacher){
        return studentRepository.getTeacherByName(teacher);
    }

    // 6
    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.getStudentsByTeacherName(teacher);
    }

    // 7
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }


    //8
    public String deleteTeacherByName(String teacher){

        return studentRepository.deleteTeacherByName(teacher);
    }

    // 9
    public String deleteAllTeachers(){
        return studentRepository.deleteAllTeachers();
    }

}