package com.example.zc.demo.service.impl;

import com.example.zc.demo.dao.StudentDao;
import com.example.zc.demo.entity.Student;
import com.example.zc.demo.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService


{

    @Resource
    private StudentDao studentDao;

    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentDao.getById(id);
    }

    @Override
    public int updateById(Integer id,Student student) {
        return studentDao.updateById(id,student);
    }

    @Override
    public int deleteById(Integer id) {
        return studentDao.deleteById(id);
    }

    @Override
    public List<Student> getStudentList(Student student) {
        return studentDao.getStudentList(student);
    }
}
