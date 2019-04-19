package com.org.main.stream;

import com.google.common.collect.Lists;
import com.org.domain.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {
    public static void main(String[] args){
        List<Student> students= Student.getStudentList();
        List<Student> students1=students.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        students1.forEach(o-> System.out.println(o.getAge()));
    }
}
