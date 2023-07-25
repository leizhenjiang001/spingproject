package org.example.web;

import com.alibaba.dubbo.config.annotation.Reference;
import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    private StudentService studentService;
    @RequestMapping(value = "/student/detail/{id}")
    @ResponseBody
    public String studentDetail(@PathVariable("id") Integer id){
    //public String studentDetail(){
        System.out.println("test________");
        Student student = studentService.queryStudentById(id);

        return "studentDetail:"+student.getName()+"age:"+student.getAge();
    }
}
