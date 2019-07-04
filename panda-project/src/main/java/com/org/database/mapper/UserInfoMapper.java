package com.org.database.mapper;

import com.org.database.model.UserInfoPO;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {

  int addUserInfo(@Param("userInfoPO") UserInfoPO userInfoPO);

  UserInfoPO getUserInfo(String userId);
}
