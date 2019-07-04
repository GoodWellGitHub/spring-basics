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
public class UserPO {

  private int id;
  private String userId;
  private String userName;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
