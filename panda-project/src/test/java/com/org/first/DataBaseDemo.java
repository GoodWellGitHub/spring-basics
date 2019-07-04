package com.org.first;

import com.org.database.mapper.UserInfoMapper;
import com.org.database.mapper.UserMapper;
import com.org.database.model.UserInfoPO;
import com.org.database.model.UserPO;
import com.org.database.service.BizService;
import com.org.database.service.UserInfoService;
import com.org.database.service.UserService;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:/spring/spring.xml")
public class DataBaseDemo {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Resource
  private UserService userService;

  @Resource
  private UserInfoService userInfoService;

  @Resource
  private BizService bizService;

  @Test
  public void Test() {
    System.out.println(userService.getUser("ab"));
  }

  @Test
  public void insert() {
    UserPO userPO = UserPO.builder().userId("ab").userName("关于").build();
    int result = userMapper.insertUser(userPO);
    System.out.println(result);
  }

  @Test
  public void insertUserInfo() {
    UserInfoPO userInfoPO = UserInfoPO.builder()
        .userId("ab")
        .name("林黛玉")
        .address("大观园")
        .age(18)
        .sex("女")
        .build();
    int result = userInfoMapper.addUserInfo(userInfoPO);
    System.out.println(result);
  }

  @Test
  public void getUserInfo() {
    UserInfoPO po = userInfoService.getUserInfo("ab");
    System.out.println(po);
  }

  @Test
  public void result() {
    int result = bizService.biz();
    System.out.println(result);
  }
}
