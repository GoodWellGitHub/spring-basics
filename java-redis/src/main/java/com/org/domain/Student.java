package com.org.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private static final long serialVersionUId=193448l;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public List<Student> getStudentList() {
        Student student = new Student();
        student.setName("嬴政");
        student.setAge(28);
        Student student1 = new Student();
        student1.setName("刘邦");
        student1.setAge(45);
        Student student2 = new Student();
        student2.setName("李世民");
        student2.setAge(35);
        Student student3 = new Student();
        student3.setName("赵匡胤");
        student3.setAge(38);

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        return students;
    }
}
