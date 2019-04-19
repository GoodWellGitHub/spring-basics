package com.org.thread.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskMain {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new RandomCallAble());
        new Thread(futureTask).start();
        try {
            Thread.sleep(5000);
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<Integer> future=executorService.submit(new RandomCallAble());
        try {
            Thread.sleep(2000);
            System.out.println("executorservice  "+future.get());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
