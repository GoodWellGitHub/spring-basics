package com.org.extend;

public class Person {
    private String name;
    public int age;
    protected char sex;
    String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(name + "正在说话");
    }

    public Person(String name) {
        this.name = name;
    }
    public Person(){

    }
}
