package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,String> {
    User findByOpenidAndPassword(String Openid,String Password);
    User findByOpenid(String Openid);
}
