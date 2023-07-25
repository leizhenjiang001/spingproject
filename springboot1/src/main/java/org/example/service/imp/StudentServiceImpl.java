package org.example.service.imp;

import org.example.mapper.StudentMapper;
import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//把接口实现类放到spring容器里并声明它是一个业务层才能让我们的控制层去调用，所以加上@Service
@Service
public class StudentServiceImpl implements StudentService {
   //业务层要用到的DAO注入进来
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        //调用(逆向工程帮我们生成的)studentMapper.selectByPrimaryKey方法
        return studentMapper.selectByPrimaryKey(id);
    }
    //end 到此为止创建工程添加几个依赖后(@Mapper,@MapperScan)用了一分钟就相当于搭建了一套完整的SSM框架

    @Transactional
    @Override
    public int updateStudentById(Student student){
        //事物:要一系列代码绑定在一起，要成功一起成功，失败一起失败保持原有结果不变 添加事物用注解@Transactional
        //修改成功
        int i = studentMapper.updateByPrimaryKeySelective(student);
        //修改失败
        int a = 10/0;
        return i;
    };
}
