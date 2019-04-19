package com.org.main.reflect;

import com.org.domain.Student;
import com.org.reflect.FieldNotNull;

public class RefelectMain {
    public static void main(String[] args) {
        FieldNotNull<Student> notNull = new FieldNotNull<>();
        Student student = new Student();
        student.setAge(18);
        student.setName("林黛玉");
        int result = notNull.countNull(student);
        System.out.println(result);
    }
}
