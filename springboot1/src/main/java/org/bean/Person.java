package org.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")
public class Person {

   private String lastName;
   private Integer age;
   private Boolean boss;
   private Date brith;
   private Map<String,Object> maps;
   private List<Object> lists;
   private Dog dog;
}
