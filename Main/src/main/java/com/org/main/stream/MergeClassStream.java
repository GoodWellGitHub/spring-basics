package com.org.main.stream;

import com.org.domain.Student;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MergeClassStream {
    public static void main(String[] args) {
        List<Student> students = Student.getStudentList();
        Map<String, Student> studentMap = students.stream().collect(Collectors.toMap(Student::getName, Function.identity(), (v1, v2) -> {
            v1.setAge(v1.getAge() + v2.getAge());
            return v1;
        }));
        studentMap.values().forEach(obj -> {
            System.out.println(obj.getName() + ":" + obj.getAge());
        });
    }
}
