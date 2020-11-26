package com.neusoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    /**
     * 显示所有
     * @return
     */
//    @GetMapping("/list")
//    public List<User> list(){
//        return repository.findAll();
//    }
    //分页参数   页数和每一页多少个

    /**
     * 分页查询
     * @param pageNum  页的开始数  默认从0开始
     * @param pageSize  每页第几个  默认每页10条数据
     * @return
     */
    @GetMapping("/list")
    public Page<User> pageQuery(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize);
        return repository.findAll(pageRequest);
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
//        Optional<User> optional = repository.findById(id);
        //假设获取不到前面的就会主动调用后面参数的内容
        //对象 :: new 创建对象的简称
//        return optional.orElseGet(User::new);
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

    /**
     * 增加
     * @param user
     * @return
     */
    @PostMapping
    public User save (@RequestBody User user){
        return repository.save(user);
    }
}
