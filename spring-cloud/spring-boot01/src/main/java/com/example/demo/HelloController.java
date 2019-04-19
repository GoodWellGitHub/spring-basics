package com.example.demo;

import com.example.demo.bean.Gril;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String sayHello() {
        return "hi ! you ";
    }

    @Autowired
    private Gril girl;

    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String girlInfo() {
        return "this girl : name=" + name + ";age=" + age;
    }

    @RequestMapping(value = "/getGril", method = RequestMethod.GET)
    public String getInfo() {
        return "name:" + girl.getName() + ";age:" + girl.getAge();
    }

}
