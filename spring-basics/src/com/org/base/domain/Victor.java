package com.org.base.domain;

import com.org.base.service.Instrument;

public class Victor {
    private Instrument instrument;
    private String song;

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public void play() {
        instrument.play();
    }
}
