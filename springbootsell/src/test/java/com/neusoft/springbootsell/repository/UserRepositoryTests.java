package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void findByOpenidAndPassword(){
        String Openid = "132";
        String Password = "456";
        User user = userRepository.findByOpenidAndPassword(Openid,Password);
        System.out.println(user);
    }


}
