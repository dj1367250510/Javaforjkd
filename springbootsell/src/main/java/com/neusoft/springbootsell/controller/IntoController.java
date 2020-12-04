package com.neusoft.springbootsell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
@Controller
@ResponseBody
public class IntoController {
    @GetMapping("/")
    public ModelAndView into(Map<String, Object> map){
        return new ModelAndView("user/login", map);
    }

}
