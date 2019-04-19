package com.org.base.service.impl;

import com.org.base.service.Instrument;
import com.org.base.service.Performer;

import java.util.Collection;

public class OneManBand implements Performer {
    private Collection<Instrument> instruments;

    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments;
    }

    public OneManBand() {
    }

    @Override
    public void perform() {
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }

}
