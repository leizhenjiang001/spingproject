package org.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 @MapperScan开启扫描mapper接口的包(所有包,只需要加一次，而@Mapper要每个DAO里都要加)
 command+p 查看属性 basePackages指定你要扫描的哪个包以及它的子包
*/
@MapperScan(basePackages = "org.example.mapper")
//这个注解会扫描所有spring的注解
@SpringBootApplication
@EnableTransactionManagement
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}

