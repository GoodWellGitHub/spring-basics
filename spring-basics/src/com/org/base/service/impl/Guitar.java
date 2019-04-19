package com.org.base.service.impl;

import com.org.base.service.Instrument;

public class Guitar implements Instrument {
    @Override
    public void play() {
        System.out.println("this is guitar");
    }
}
