package com.org.main.stream;

import com.google.common.collect.Lists;
import com.org.domain.Student;

import java.util.List;

public class FindFirst {
    public static void main(String[] args) {
        List<Student> student = Student.getStudentList();
        Student student1 = student.stream().filter(student2 -> {
            return student2.getAge() == 108;
        }).findFirst().orElse(null);
        System.out.println(student1==null);

        List<String> strings=Lists.newArrayListWithCapacity(0);
        strings.remove("a");
        System.out.println(strings);

        byte b=1;

        System.out.println(b==1);
    }
}
