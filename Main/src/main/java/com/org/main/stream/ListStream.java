package com.org.main.stream;

import com.google.common.collect.Lists;
import com.org.domain.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListStream {
    public static void main(String[] args) {
        List<Student> studentList = Student.getStudentList();
        Map<String, List<Student>> studentMap = studentList.stream().collect(Collectors.groupingBy(Student::getName));

        List<Integer> aa = Lists.newArrayList();
        aa.add(1);
        int a = aa.stream().findFirst().orElse(12);
        System.out.println(a);

        studentList.forEach(System.out::println);
        System.out.println("#######################3");
        List<Student> subStudent=studentList.subList(1,2);
        subStudent.forEach(System.out::println);

        Integer[] integers=new Integer[3];
        Class cl=integers.getClass();
        System.out.println(cl);
        System.out.println(cl.getComponentType());
    }
}
