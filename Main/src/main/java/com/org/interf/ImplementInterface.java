package com.org.interf;

import com.org.interf.impl.People;

public class ImplementInterface {
    public static void main(String[] args){
        People people=new People();
        people.eat();
        people.walk();
        System.out.println("--------------------");
        AnimalBaseAction peo=new People();
        peo.eat();
        peo.walk();
    }
}
