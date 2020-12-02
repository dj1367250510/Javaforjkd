package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dataobject.User;
import com.neusoft.springbootsell.enums.ResultEnum;
import com.neusoft.springbootsell.repository.UserRepository;
import com.neusoft.springbootsell.services.UserService;
import com.neusoft.springbootsell.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User res(User user) {
        String Openid = user.getOpenid();
        String Password = user.getPassword();
        User result = repository.findByOpenidAndPassword(Openid,Password);
        if(result != null){
            throw new UserException(ResultEnum.USER_EXIST);
        }
        String Username = user.getUsername();
        user.setUsername(Username);
        user.setOpenid(Openid);
        user.setPassword(Password);
        return repository.save(user);
    }

    @Override
    public User login(String Openid, String Password) {
        User result = repository.findByOpenid(Openid);
        if(result == null){
            throw new UserException(ResultEnum.USER_MISS);
        }
        if(!Password.equals(result.getPassword())){
            throw new UserException(ResultEnum.USER_PASSWORD_ERROR);
        }
        User user = new User();
        String Username = user.getUsername();
        user.setUsername(Username);
        user.setOpenid(Openid);
        user.setPassword(Password);
        return user;
    }
}
