package com.org.extend;

public class TeacherPersonDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        //teacher.name="zhangsan";
        teacher.setName("张三");
        teacher.sex = '男';
        teacher.age = 10;
        teacher.country = "中国";
        teacher.getName();
        teacher.speak();
    }
}
