package com.org.safe;

import com.org.domain.PrivateDO;

public class PrivateDemo {
    public static void main(String[] args) {
        PrivateDO privateDO = new PrivateDO();
        privateDO.setB(12);
        System.out.println("a->" + privateDO.getA());
        System.out.println("b->" + privateDO.getB());
    }
}
