package com.example.zc.demo.dao;

import com.example.zc.demo.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface StudentDao {

    int add(Student student);

    Student getById(Integer id);

    int updateById(@Param("id") Integer id, @Param("student") Student student);

    int deleteById(Integer id);

    List<Student> getStudentList(Student student);
}
