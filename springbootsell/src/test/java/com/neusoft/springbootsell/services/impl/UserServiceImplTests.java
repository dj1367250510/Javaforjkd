package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dataobject.User;
import org.hibernate.service.spi.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTests {

   @Autowired
   private UserServiceImpl userService;

   @Test
    public void res(){
       User user = new User();
      String Openid = "222";
      String Password = "111";
      String Username ="小明";
      user.setUsername(Username);
      user.setOpenid(Openid);
      user.setPassword(Password);
      userService.res(user);
   }

    @Test
    public void login(){
    try{
        String Openid = "132";
        String Password = "456";
        User result = userService.login(Openid,Password);
        System.out.println(result);
    }catch (ServiceException e){
        System.out.println(e.getClass().getName());
        System.out.println(e.getClass());
        }
    }
}
