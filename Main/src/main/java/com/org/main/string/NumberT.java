package com.org.main.string;

import java.math.BigDecimal;

public class NumberT {
    public static void main(String[] args){
        BigDecimal decimal=new BigDecimal(1);
        String ss=decimal.divide(new BigDecimal(100)).setScale(2).toString();
        System.out.println(ss);
        System.out.println(decimal.divide(new BigDecimal(100)).setScale(2));
    }
}
