package com.org.database.service;

import com.org.database.mapper.UserInfoMapper;
import com.org.database.mapper.UserMapper;
import com.org.database.model.UserInfoPO;
import com.org.database.model.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BizService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Transactional(rollbackFor = Exception.class)
  public int biz() {
    int result = 0;
    UserPO userPO = UserPO.builder().userId("ab").userName("伊娃").build();
    int userResult = userMapper.insertUser(userPO);
    System.out.println("var1" + userResult);
    UserInfoPO userInfoPO = UserInfoPO.builder().userId("km").name("薛宝钗").age(19).address("大观园")
        .sex("女").build();
    int userInfoResult = userInfoMapper.addUserInfo(userInfoPO);
    System.out.println("var2" + userInfoResult);
    result = userInfoResult + userResult;
    System.out.println("var3" + result);
    return result;
  }
}
