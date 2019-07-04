package com.org.log.springlogv2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerAspect {
  private  final Logger logger= LoggerFactory.getLogger(this.getClass());

  @Pointcut("execution(public int *.test(Long,String)) ||execution(public int *.test(Integer, String))")
  public void pointCuntName(){}

  @Around("pointCuntName()")
  public Object doIt(ProceedingJoinPoint joinPoint) throws Throwable{
    long startTime = System.currentTimeMillis();
    Object obj = null;
    try {
      obj = joinPoint.proceed();
      return obj;
    }
    finally {
      long costTime = System.currentTimeMillis() - startTime;
      MethodSignature signature = (MethodSignature)joinPoint.getSignature();
      logger.info("method={}, args={}, cost_time={}, result={}", signature.getName(), signature.getParameterNames(), costTime, obj);
    }
  }

}
