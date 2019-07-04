package org.hj.common.log;

import java.lang.reflect.Method;
import org.apache.logging.log4j.core.tools.picocli.CommandLine.Command;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OperationLogAspect {
  private static final Logger logger= LoggerFactory.getLogger(OperationLogAspect.class);

  @Pointcut("@annotation(org.hj.common.log.OperationLog)")
  public void serviceAspect(){}

  @After("serviceAspect()")
  public void doAfter(JoinPoint joinPoint){
    String targetName = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    Object[] arguments = joinPoint.getArgs();
    Class targetClass = null;
    try {
      targetClass = Class.forName(targetName);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    Method[] methods = targetClass.getMethods();
    String description = "";
    for (Method method : methods) {
      if (method.getName().equals(methodName)) {
        Class[] clazzs = method.getParameterTypes();
        if (clazzs.length == arguments.length) {
          description = method.getAnnotation(OperationLog.class).value();
          break;
        }
      }
      System.out.println(description);
    }
  }

}
