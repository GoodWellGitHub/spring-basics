package com.org.base.service.impl;

import com.org.base.service.Performer;
import org.springframework.stereotype.Component;

@Component
public class Juggler implements Performer {
    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() {
        System.out.println("Juggler " + beanBags + " beanbangs");
    }
}
