package com.org.sericefeign.feign.impl;

import com.org.sericefeign.feign.SchedualServiceHi;

public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientone(String name) {
        return "sorry "+name;
    }
}
