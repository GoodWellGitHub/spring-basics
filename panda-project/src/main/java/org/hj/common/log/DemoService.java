package org.hj.common.log;

import java.util.List;
import org.hj.common.log.domain.Student;
import org.hj.common.log.level.SystemServiceLog;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  @SystemServiceLog(description = "caozuo")
  public String doSome(String a) {
    System.out.println("方法执行");
    return "增加  :  " + a;
  }

  @SystemServiceLog(description = "学生集合")
  public String doSome(List<Student> a) {
    System.out.println("方法执行 ..学生集合");
    return "增加  :  " + a;
  }
}
