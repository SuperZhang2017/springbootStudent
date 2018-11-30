package com.example.zc.demo.controller;



import com.example.zc.demo.entity.Student;
import com.example.zc.demo.service.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    private static Log logger = LogFactory.getLog(StudentController.class);

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable(value = "id") Integer id){
        Student student;

        try {
             student = studentService.getById(id);
             logger.info("student="+student);
        }catch (Exception e){
            student = null;
            e.printStackTrace();
        }

        System.out.println("-------------热部署测试修改后-----------");

        return student;

    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResponseEntity<Integer> add(@RequestBody Student student){

        Integer a;
        try{
             a  = studentService.add(student);
        }catch (Exception e){
            a= null;
          e.printStackTrace();
        }
        System.out.println(a);

        return ResponseEntity.ok(a);
    }

    @RequestMapping(value = "/updateById/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<Integer> update(@PathVariable(value = "id") Integer id,@RequestBody Student student){
        Integer a;

        try {
            a = studentService.updateById(id,student);
        } catch (Exception e) {
            a = null;
            e.printStackTrace();
        }
        System.out.println(a);
        return ResponseEntity.ok(a);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteById/{id}" ,method = RequestMethod.DELETE)
    public ResponseEntity<Integer> delete(@PathVariable(value = "id") Integer id){
        Integer d;

        try {
            d = studentService.deleteById(id);
        } catch (Exception e) {
            d = null;
            e.printStackTrace();
        }

        System.out.println(d+"，热部署修改后");
        return ResponseEntity.ok(d);
    }


    @RequestMapping(value = "/getStudentList",method = RequestMethod.POST)
    public ResponseEntity<List<Student>> getStudentList(@RequestBody Student student){
        List<Student> list;

        try {
            list = studentService.getStudentList(student);
        } catch (Exception e) {
            list = null;
            e.printStackTrace();
        }

        System.out.println(list);
        return ResponseEntity.ok(list);

    }



}
