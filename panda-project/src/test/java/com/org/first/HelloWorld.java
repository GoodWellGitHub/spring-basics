package com.org.first;

import java.lang.reflect.AnnotatedElement;

public class HelloWorld {

  public static void main(String[] args) {
    String[] strings = new String[0];
    System.out.println("Hello world");
    System.out.println();
    Class stringClass = String.class;
    Integer i1 = 121;
    Integer i2 = 121;
    System.out.println(i1 == i2);
    Integer i3 = 200;
    Integer i4 = 200;
    System.out.println(i3 == i4);
  }
}
