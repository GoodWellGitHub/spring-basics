package com.org.domain;

import com.google.common.collect.Lists;
import com.org.interf.BaseClass;

import java.util.List;

public class Student implements BaseClass {
    private String name;
    private String desc;
    private int age;
    private int studentId;
    private String school;
    private String profession;
    private boolean isman;

    public boolean isIsman() {
        return isman;
    }

    public void setIsman(boolean isman) {
        this.isman = isman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", age=" + age +
                ", studentId=" + studentId +
                ", school='" + school + '\'' +
                ", profession='" + profession + '\'' +
                ", isman=" + isman +
                '}';
    }

    public static List<Student> getStudentList() {
        Student student1 = new Student();
        student1.setName("林黛玉");
        student1.setAge(18);

        Student student2 = new Student();
        student2.setName("林黛玉");
        student2.setAge(19);

        Student student3 = new Student();
        student3.setName("林黛玉");
        student3.setAge(17);

        Student student4 = new Student();
        student4.setName("贾迎春");
        student4.setAge(28);

        List<Student> students = Lists.newArrayList();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        return students;
    }
}
