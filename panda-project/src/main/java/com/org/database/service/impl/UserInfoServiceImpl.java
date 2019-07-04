package com.org.database.service.impl;

import com.org.database.mapper.UserInfoMapper;
import com.org.database.model.UserInfoPO;
import com.org.database.service.UserInfoService;
import org.hj.common.log.level.SystemServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public int addUserInfo(UserInfoPO userInfoPO) {
    return userInfoMapper.addUserInfo(userInfoPO);
  }

  @Override
  @SystemServiceLog
  public UserInfoPO getUserInfo(String userId) {
    return userInfoMapper.getUserInfo(userId);
  }
}
