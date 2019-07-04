package com.org.database.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoPO {

  private int id;
  private String userId;
  private String name;
  private String address;
  private int age;
  private String sex;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
