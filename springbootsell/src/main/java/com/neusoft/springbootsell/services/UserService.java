package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.User;
public interface UserService {

    User res (User user);

    User login(String Openid,String Password);

}
