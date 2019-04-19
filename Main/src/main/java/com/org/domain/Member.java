package com.org.domain;

import com.org.list.Department;

public class Member {
    private String name;
    private int age;
    private Department department;

    public Member(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String toString(){
        StringBuffer sb=new StringBuffer();
        sb.append("员工名="+name);
        sb.append(" 年龄="+age);

        if(department!=null){
            sb.append(" 所属部门="+department);
        }

        return sb.toString();
    }

    public int getAge() {
        return age;
    }

    public Department getDepartment() {
        return department;
    }

    public void changeNewDepartment(Department newDepartment) {
       // department.removeMemer(name);
        newDepartment.addMemer(this);
    }

    public String getName() {
        return name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
