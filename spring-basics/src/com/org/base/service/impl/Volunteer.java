package com.org.base.service.impl;

import com.org.base.service.Thinkeer;

public class Volunteer implements Thinkeer {
    private String thoughts;

    @Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
