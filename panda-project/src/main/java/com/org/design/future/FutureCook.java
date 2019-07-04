package com.org.design.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureCook {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long start = System.currentTimeMillis();
    Callable<Chuju> onlineShopping = new Callable<Chuju>() {
      public Chuju call() throws Exception {
        System.out.println("下单买厨具...");
        System.out.println("等待送货...");
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("快递送到...");
        return new Chuju();
      }
    };
    FutureTask<Chuju> chujuFutureTask = new FutureTask<Chuju>(onlineShopping);
    new Thread(chujuFutureTask).start();
    Thread.sleep(2000);
    Shicai shicai = new Shicai();
    System.out.println("食材到位。。。。");
    if (!chujuFutureTask.isDone()) {
      System.out.println("厨具怎么还没到。。快递有点慢了");
    }
    Chuju chuju = chujuFutureTask.get();
    cookie(chuju, shicai);
    System.out.println("总共耗时...." + (System.currentTimeMillis() - start));

  }


  static class Chuju {

  }

  static class Shicai {

  }

  static void cookie(Chuju chuju, Shicai shicai) {
    System.out.println("烹饪中//////");
  }

}
