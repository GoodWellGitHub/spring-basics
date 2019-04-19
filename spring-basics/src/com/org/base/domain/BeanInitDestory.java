package com.org.base.domain;

public class BeanInitDestory {
    private String name;
    private String age;

    public void begin() {
        System.out.println("BeanInitDestory的初始化开始.....");
        System.out.println("name=" + name + "age=" + age);
    }

    public void end() {
        System.out.println("BeanInitDestory销毁.......");
        System.out.println("name=" + name + "age=" + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
