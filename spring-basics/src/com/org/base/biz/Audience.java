package com.org.base.biz;

public class Audience {
    public Audience(){}
    public void takeSeats() {
        System.out.println("The audience is take their seats");
    }

    public void turnOffCellPhone() {
        System.out.println("The audience is turn off their phone");
    }

    public void applaud() {
        System.out.println("CLAP  CLAP  CLAP  CLAP");
    }

    public void demandRefund() {
        System.out.println("Boo ! we want our money back ! ");
    }

    public void watchFormance(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("The audience is taking their seats .....");
            System.out.println("the audience is turning off their cellphone ....");
            long start = System.currentTimeMillis();
            proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("the audience CLAP CLAP CLAP  ....");
            System.out.println("thie perform took " + (end - start) + "milliseconds");
        } catch (Throwable e) {
            System.out.println("We can't be doSomething!");
        }
    }
}
