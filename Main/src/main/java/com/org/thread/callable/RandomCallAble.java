package com.org.thread.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomCallAble implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}
