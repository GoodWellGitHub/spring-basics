package com.org.log.springlogv1;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceInterceptor implements MethodInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(ServiceInterceptor.class);

  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    long start = System.currentTimeMillis();
    Object obj = null;
    try {
      obj = methodInvocation.proceed();
      return obj;
    } finally {
      long costTime = System.currentTimeMillis() - start;
      logger.info("method={}, args={}, cost_time={}, result={}", methodInvocation.getMethod(),
          methodInvocation.getArguments(), costTime, obj);
    }
  }
}
