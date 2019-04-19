package com.org.interf.impl;

import com.org.interf.AnimalBaseAction;

public class People implements AnimalBaseAction {
    @Override
    public void walk() {
        System.out.println("人类用两条腿走路");
    }
}
