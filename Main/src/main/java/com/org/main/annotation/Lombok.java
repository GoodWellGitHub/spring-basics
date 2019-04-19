package com.org.main.annotation;

import com.org.domain.Teacher;

public class Lombok {
    public static void main(String[] args){
        Teacher.TeacherBuilder teacherBuilder=Teacher.builder();
        teacherBuilder.name("hello");
        Teacher teacher1=teacherBuilder.build();
        Teacher teacher2=teacherBuilder.build();
        System.out.println(teacher1==teacher2);
    }
}
