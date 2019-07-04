package com.org.first;

import org.hj.common.log.DemoService;
import org.hj.common.log.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:/spring/spring.xml")
public class LogDemo {

  @Autowired
  private DemoService demoService;

  @Test
  public void doth() {
    demoService.doSome(Student.studentList());
  }
}
