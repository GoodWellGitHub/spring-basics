package com.org.interf;

public interface AnimalBaseAction {
    void walk();

    default void eat() {
        System.out.println("吃都是相同的");
    }
}
