package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTsets {
    //在有Spring的地方这样创建对象 不用new
    @Autowired
    private UserRepository repository;

    @Test
    public void listAll(){
        List<User> list = repository.findAll();
        for(User user: list){
            System.out.println(user);
        }
    }

    @Test
    public void findById(){
        String id = "8a04ae2975fe9cc90175fe9ccc280000";
        Optional<User> optional = repository.findById(id);
        User user = optional.get();
        System.out.println(user);
    }
    @Test
    public void save(){
        User user = new User();
        user.setUsername("王也");
        user.setPassword("13");
        user.setEmail("123@qq.com");
        repository.save(user);
    }

    @Test
    public void delete(){
        String id = "8a04ae2975fe9d7c0175fe9d7ed60000";
        repository.deleteById(id);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId("8a04ae2975fe9d7c0175fe9d7ed60000");
        user.setUsername("李四");
        user.setPassword("123");
        user.setEmail("mm");
        repository.save(user);
    }
}
