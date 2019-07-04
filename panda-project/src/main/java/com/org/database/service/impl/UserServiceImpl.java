package com.org.database.service.impl;

import com.org.database.mapper.UserMapper;
import com.org.database.model.UserPO;
import com.org.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public int addUser(UserPO userPO) {
    return userMapper.insertUser(userPO);
  }

  @Override
  public UserPO getUser(String userId) {
    return userMapper.getUser(userId);
  }
}
