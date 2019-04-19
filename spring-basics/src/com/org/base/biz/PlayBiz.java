package com.org.base.biz;

import com.org.base.service.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayBiz {

    private Instrument instrument;


    public PlayBiz(Instrument instrument) {
        this.instrument = instrument;
    }

    @Autowired
    public void hello(Instrument instrument) {
        this.instrument = instrument;
        System.out.println("初始化乐器........");
    }

    public void play() {
        instrument.play();
    }
}
