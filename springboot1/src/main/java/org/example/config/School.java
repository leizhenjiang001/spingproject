package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//想把School类的配置映射到对象里，在别处可以取到对象里到值，就要把School类通过注解@Component交给spring容器进行管理
@Component  //@Component 把类交给spring容器进行管理
@ConfigurationProperties(prefix = "school") //这个类设置成配置类  区分不同到类里到name   如shool.name

public class School {

    private String name;

    private String websit;

    public String getWebsit() {
        return websit;
    }

    public void setWebsit(String websit) {
        this.websit = websit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
