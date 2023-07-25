package org.example.controller;

import org.example.config.School;
import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class MyController {
    /*
        @Autowired //将容器里到类注入进来 注入的是School对象
        private School school;

        @Value("${school.name}") //@Value 在controller或业务层，哪里都可以这样用获取自定义参数的值
        private String schoolName;

        @Value("${school.websit}") //@Value 在controller或业务层，哪里都可以这样用获取自定义参数的值
        private String schoolWebsit;
*/

    @Autowired //将容器里到类注入进来 注入的是School对象
    private School school;

    @Autowired //将容器里到类注入进来 注入的是student业务层对象
    private StudentService studentService;

    @RequestMapping("/hello")
    public String index() {
        return "hello1:"+school.getName()+"websit1:"+school.getWebsit();
    }

    //@ResponseBody拿到当对象详情最终转换为json
    //public @ResponseBody Object student(Integer id) {}
    @RequestMapping("/student")
    public Object student(Integer id) {
        //调用业务层的方法
        Student student = studentService.queryStudentById(id);
        return student;
    }


    //事物
    @RequestMapping("/update")
    public Object update(Integer id,String name) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        //调用业务层的方法
        int updateCount = studentService.updateStudentById(student);
        return "修改学生编号为"+id+"的姓名为"+updateCount;
    }

    //RequestMapping默认接收GET和POST
    @RequestMapping(value = "/queryStudentById1",method = {RequestMethod.GET,RequestMethod.POST})
    public Object queryStudentById1 () {
        Student student = new Student();
        student.setId(1);
        student.setName("testname1");
        return student;
    }

    @RequestMapping(value = "/queryStudentById2",method = RequestMethod.GET)
    //相当于@GetMapping(value = "/queryStudentById2")
    public Object queryStudentById2 () {
        Student student = new Student();
        student.setId(2);
        student.setName("testname2");
        return student;
    }
    //@RequestMapping(value = "/queryStudentById3",method = RequestMethod.POST)
    @PostMapping(value = "/queryStudentById3")
    public Object queryStudentById3 () {
        Student student = new Student();
        student.setId(3);
        student.setName("post-testname3");
        return student;
    }
    //@RequestMapping(value = "/queryStudentById3",method = RequestMethod.DELETE)
    @DeleteMapping(value = "/delete")
    public Object delete () {
        Student student = new Student();
        student.setId(3);
        student.setName("delete-testname");
        return student;
    }

    //@RequestMapping(value = "/updatetest",method = RequestMethod.PUT)
    @PutMapping(value = "/updatetest")
    public Object updatetest () {
        Student student = new Student();
        student.setId(3);
        student.setName("update-testname");
        return student;
    }

}

