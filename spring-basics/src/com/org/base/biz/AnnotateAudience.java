package com.org.base.biz;

import org.aspectj.lang.annotation.*;

@Aspect
public class AnnotateAudience {
    @Pointcut("execution(* com.org.base.service.Performer.perform(..))*")
    public void performance() {
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("take the seats");
    }

    @Before("performance()")
    public void turnOffPhone() {
        System.out.println("take off the phone");
    }

    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("CLAP  CLAP  CLAP.........");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Boo ! we want our money back !");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("The audience is taking thier seats");
            System.out.println("The audience is turn off their phone");
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("CLAP CLAP CLAP");
            System.out.println("the audience took " + (end - start) + " mill secends");
        } catch (Throwable t) {
            System.out.println(" BOO ! we want our money back !");
        }
    }
}
