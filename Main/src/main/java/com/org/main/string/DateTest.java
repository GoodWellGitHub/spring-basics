package com.org.main.string;

import com.alibaba.fastjson.JSON;
import com.org.domain.Data;
import com.org.domain.Student;

import java.time.LocalDateTime;

public class DateTest {
    public static void main(String[] args) {
/*        Student student = new Student();
        student.setAge(12);
        student.setName("hjwang");
        student.setStudentId(1223);
        Data data = new Data();
        data.setCode(123);
        data.setData(student);
        String ss = JSON.toJSONString(data);
        System.out.println(ss);
        Data data1 = JSON.parseObject(ss, Data.class);

        System.out.println(data1.getData());
        Student student2=JSON.parseObject(data1.getData().toString(),Student.class);
        //Student student1 = (Student) data1.getData();
        System.out.println(student2);
        System.out.println(data1.getCode());*/
        System.out.println(LocalDateTime.now());
    }
}
