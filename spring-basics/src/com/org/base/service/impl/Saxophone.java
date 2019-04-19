package com.org.base.service.impl;

import com.org.base.service.Instrument;


public class Saxophone implements Instrument {
    public Saxophone() {
    }

    @Override
    public void play() {
        System.out.println("TOOT TOOT TOOT");
    }
}
