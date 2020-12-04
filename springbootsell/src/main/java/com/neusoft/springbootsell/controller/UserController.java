package com.neusoft.springbootsell.controller;


import com.neusoft.springbootsell.exception.UserException;
import com.neusoft.springbootsell.form.UserForm;
import com.neusoft.springbootsell.services.UserService;
import com.neusoft.springbootsell.dataobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/seller/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(Map<String, Object> map) {
        return new ModelAndView("user/login",map);
    }

    @GetMapping("/register")
    public ModelAndView res(Map<String, Object> map) {
        return new ModelAndView("user/register",map);
    }

    @PostMapping("/res")
    public ModelAndView res(@Valid UserForm form,
                                 BindingResult bindingResult,
                                 Map<String, Object> map){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/user/register");
            return new ModelAndView("common/error", map);
        }
        if(!form.getFirpassword().equals(form.getSecpassword())){
            map.put("msg","密码不一致");
            map.put("url","/seller/user/register");
            return new ModelAndView("common/error", map);
        }
        User user = new User();
        try{
            System.out.println(form);
            user.setOpenid(form.getOpenid());
            user.setUsername(form.getUsername());
            user.setPassword(form.getFirpassword());
            userService.res(user);
        }catch (UserException e){
            map.put("msg",e.getMessage());
            map.put("url","/seller/user/register");
            return new ModelAndView("common/error", map);
        }
        map.put("url","/seller/user/login");
        return new ModelAndView("common/success", map);
    }

    @PostMapping("/log")
    public ModelAndView login(@Valid UserForm form,
                            BindingResult bindingResult,
                            Map<String, Object> map){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/user/login");
            return new ModelAndView("common/error", map);
        }
        try{
            userService.login(form.getOpenid(),form.getFirpassword());
        }catch (UserException e){
            map.put("msg",e.getMessage());
            map.put("url","/seller/user/login");
            return new ModelAndView("common/error", map);
        }
        map.put("url","/seller/product/list");
        return new ModelAndView("common/success", map);
    }

}


