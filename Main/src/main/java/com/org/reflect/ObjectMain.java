package com.org.reflect;

import com.google.common.collect.Lists;
import com.org.domain.Student;

import java.util.Arrays;
import java.util.List;

public class ObjectMain {
    public static void main(String[] args) {
        Student student=new Student();
        Object obs= Arrays.asList(student);
        Object astu=student;
        if (obs instanceof List){
            System.out.println("是");
            List<Student> students=(List<Student>)obs;
            students.forEach(System.out::println);
        }else {
            System.out.println("bushi");
        }

    }
}
