package com.org.operation;

import java.util.concurrent.atomic.AtomicInteger;

public class AndOr {
    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(COUNT_BITS);
        int RUNNING = -1 << COUNT_BITS;
        System.out.println(RUNNING);
        int SHUTDOWN = 0 << COUNT_BITS;
        System.out.println(SHUTDOWN);
        int STOP = 1 << COUNT_BITS;
        System.out.println(STOP);
        int TIDYING = 2 << COUNT_BITS;
        System.out.println(TIDYING);
        int terminated = 3 << COUNT_BITS;
        System.out.println(terminated);
        int CAPACITY = (1 << COUNT_BITS) - 1;
        System.out.println(CAPACITY);
        System.out.println("$$$$$$$$$$$");
        AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
        System.out.println(ctl.get());
        System.out.println(workerCountOf(ctl.get()));
        System.out.println(ctl.get());


    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    private static int workerCountOf(int c) {
        return c & 536870911;
    }
    private static int runStateOf(int c)     { return c & ~536870911; }


}
