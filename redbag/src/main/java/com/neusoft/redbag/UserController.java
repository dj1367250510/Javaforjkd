package com.neusoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/us")
public class UserController {
    @Autowired
    private UserRepository repository;

    /**
     * 显示所有
     * @return
     */
    @GetMapping("/list")
    public List<User> list(){
        return repository.findAll();
    }

    /**
     * 修改
     * @param name
     * @param password
     * @param email
     * @return
     */
    @PostMapping("/change")
    public User changeuser(String name,String password,String email){
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);
        return repository.save(user);
    }

    /**
     * 查找
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public User findById(@PathVariable("id") String id){
        return repository.findById(id).orElse(null);
    }

    /**
     * 删除
     * @param id
     */
    @GetMapping("/delete{id}")
    public void deleteById(@PathVariable("id") String id){
        repository.deleteById(id);
    }

}
