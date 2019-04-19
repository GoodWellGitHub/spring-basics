package com.org.base.service.impl;

import com.org.base.service.Instrument;
import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println("this is piano");
    }
}
