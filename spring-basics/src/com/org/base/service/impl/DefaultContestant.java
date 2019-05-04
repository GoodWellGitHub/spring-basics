package com.org.base.service.impl;

import com.org.base.service.Contestant;

public class DefaultContestant implements Contestant {
    @Override
    public void receiveAward() {
        System.out.println("contestant default implements");
    }
}
