package com.org.design.future;

public class CommonCook {

  public static void main(String[] args) throws InterruptedException {
    long start = System.currentTimeMillis();
    OnlineShopping onlineShopping = new OnlineShopping();
    onlineShopping.start();
    onlineShopping.join();
    Thread.sleep(2000);
    Shicai shicai = new Shicai();
    System.out.println("食材到位...");
    System.out.println("开始展示厨艺。。。");
    cookie(onlineShopping.chuju, shicai);
    System.out.println("总共耗时 " + (System.currentTimeMillis() - start));


  }

  static class OnlineShopping extends Thread {

    private Chuju chuju;

    public void run() {
      System.out.println("下单买厨具...");
      System.out.println("等待送货...");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("快递送到...");
      chuju = new Chuju();
    }
  }

  static class Chuju {

  }

  static class Shicai {

  }

  static void cookie(Chuju chuju, Shicai shicai) {
    System.out.println("烹饪中//////");
  }
}
