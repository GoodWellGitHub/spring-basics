package com.org.consts;

import com.org.domain.PrivateDO;
import com.org.domain.Student;

public class XXExtendPO extends PrivateDO {

    static Student student = new Student();
    static Student student1 = new Student();
    static ThreadLocal<Student> studentThreadLocal = new ThreadLocal<>();


    public void vis() {
        System.out.println(student);
        b = 1;
        c = 2;

    }

    public static void main(String[] args) {
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());

        studentThreadLocal.set(student);
        System.out.println(studentThreadLocal.get().hashCode());

        Task task1=new Task();
        new Thread(new Task()).start();
        new Thread(new Task()).start();


    }

   static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println(XXExtendPO.studentThreadLocal.get().hashCode());
        }
    }
}
