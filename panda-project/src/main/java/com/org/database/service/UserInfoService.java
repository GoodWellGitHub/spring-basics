package com.org.database.service;

import com.org.database.model.UserInfoPO;

public interface UserInfoService {

  int addUserInfo(UserInfoPO userInfoPO);

  UserInfoPO getUserInfo(String userId);
}
