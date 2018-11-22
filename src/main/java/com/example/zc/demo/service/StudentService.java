package com.example.zc.demo.service;

import com.example.zc.demo.entity.Student;

import java.util.List;

public interface StudentService {

    int add(Student student);

    Student getById(Integer id);

    int updateById(Integer id,Student student);

    int deleteById(Integer id);

    List<Student> getStudentList(Student student);

}
