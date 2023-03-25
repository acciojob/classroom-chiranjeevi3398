package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {

    Map<String,Student> studentMap;
    Map<String,Teacher> teacherMap;
    Map<String, List<String>> pairMap;

    public StudentRepository(){
        studentMap=new HashMap<>();
        teacherMap=new HashMap<>();
        pairMap=new HashMap<>();
    }

    public void addStudent(Student student){
        if(!studentMap.containsKey(student.getName()))
            studentMap.put(student.getName(), student);
    }

    public  void addTeacher(Teacher teacher){
        if(!teacherMap.containsKey(teacher.getName()))
            teacherMap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student,String teacher){
        if(!studentMap.containsKey(student) || !teacherMap.containsKey(teacher))
            return;
        if(pairMap.containsKey(teacher)){
            pairMap.get(teacher).add(student);
        }else{
            List<String> list=new ArrayList<>();
            list.add(student);
            pairMap.put(teacher,list);
        }
    }

    public Student getStudentByName(String student){
        if(!studentMap.containsKey(student))
            return null;
        return studentMap.get(student);
    }

    public Teacher getTeacherByName(String teacher){
        if(!teacherMap.containsKey(teacher))
            return null;
        return teacherMap.get(teacher);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return pairMap.get(teacher);
    }
    public List<String> getAllStudents(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacherByName(String teacher){
        List<String> students=pairMap.get(teacher);
        pairMap.remove(teacher);
        for(String s: students){
            if(studentMap.containsKey(s))
                studentMap.remove(s);
        }
        if(teacherMap.containsKey(teacher))
            teacherMap.remove(teacher);
    }

    public void deleteAllTeachers(){
        for(String t: pairMap.keySet()){
            for(String s: pairMap.get(t)){
                if(studentMap.containsKey(s))
                    studentMap.remove(s);
            }
        }
        pairMap.clear();
        teacherMap.clear();
    }
}
