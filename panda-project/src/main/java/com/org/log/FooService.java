package com.org.log;

public class FooService {

  public String dosomeThing(Integer integer) {
    int count = integer++;
    return "fooservice" + count + "";
  }

}
