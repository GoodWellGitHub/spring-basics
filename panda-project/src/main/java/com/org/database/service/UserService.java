package com.org.database.service;

import com.org.database.model.UserPO;

public interface UserService {

  int addUser(UserPO userPO);

  UserPO getUser(String userId);
}
