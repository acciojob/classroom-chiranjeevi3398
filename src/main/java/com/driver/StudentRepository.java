package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<String,Student> studentMap = new HashMap<>();
    Map<String,Teacher> teacherMap = new HashMap<>();
    Map<String,String> studentTeacherPairMap = new HashMap<>();

    Map<String, List<String>> teacherStudentList = new HashMap<>();

    public String addStudent(Student student){
        studentMap.put(student.getName(),student);
        return "Add successively";
    }

    public String addTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
        return "Teacher Added";
    }

    // 3
    public String addStudentTeacherPair(String student,String teacher){
        if(teacherStudentList.containsKey(teacher)){
            List<String> list = teacherStudentList.get(teacher);
            list.add(student);
            studentTeacherPairMap.put(student,teacher);
        }else{
            List<String> list = new ArrayList<>();
            list.add(student);
            teacherStudentList.put(teacher,list);
            studentTeacherPairMap.put(student,teacher);
        }

        return "pair added";
    }

    // 4
    public Student getStudentByName(String student){
        return studentMap.get(student);
    }

    // 5
    public Teacher getTeacherByName(String teacher){
        return teacherMap.get(teacher);
    }

    // 6
    public List<String> getStudentsByTeacherName(String teacher){
        return teacherStudentList.get(teacher);
    }

    // 7
    public List<String> getAllStudents(){
        List<String> list = new ArrayList<>();
        for(String x : studentMap.keySet()){
            list.add(x);
        }
        return list;
    }


    //8
    public String deleteTeacherByName(String teacher){
        List<String> list = teacherStudentList.get(teacher);
        for (int i=0;i<list.size();i++){
            studentMap.remove(list.get(i));
        }
        teacherMap.remove(teacher);
        return "delete successively";
    }

    // 9
    public String deleteAllTeachers(){
        for(String teacher : teacherMap.keySet()){
            if(teacherStudentList.containsKey(teacher)){
                List<String> list = teacherStudentList.get(teacher);
                for (int i=0;i<list.size();i++){
                    studentMap.remove(list.get(i));
                }
                teacherStudentList.remove(teacher);
            }
        }
        teacherMap.clear();
        return "delete successively";
    }
}
