package com.bjpowernode.springboot;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
//import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDubboConfiguration //开启dubbo配置 和@SpringBootApplication各扫描各家的
@EnableDubbo
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}
