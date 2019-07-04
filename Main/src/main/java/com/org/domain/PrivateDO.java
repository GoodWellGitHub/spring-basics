package com.org.domain;

public class PrivateDO {
    private int data;
    int a;
    protected int b;
    public int c;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getA() {
        return a;
    }

    private void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        setA(b);
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
