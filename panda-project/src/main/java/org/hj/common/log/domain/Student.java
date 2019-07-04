package org.hj.common.log.domain;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  private String name;
  private int age;

  public static List<Student> studentList() {
    Student student = Student.builder().name("林黛玉").age(18).build();
    Student student1 = Student.builder().name("薛宝钗").age(19).build();
    return Arrays.asList(student, student1);
  }
}
