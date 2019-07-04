package com.org.database.mapper;

import com.org.database.model.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

  UserPO getUser(String userId);

  int insertUser(@Param("userPO") UserPO userPO);

}
