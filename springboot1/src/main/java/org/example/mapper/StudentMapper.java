package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.Student;
//我们的业务层想注入我们的DAO，我们就用到了注解@Mapper
//@Mapper mybatis的前身就是ibatis 扫描DAO接口到spring容器
//@Mapper //如果不想一个一个加去扫描，想扫描org.example.mapper下的所有，就在启动入口类(@SpringBootApplication)上面加@MapperScan
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
