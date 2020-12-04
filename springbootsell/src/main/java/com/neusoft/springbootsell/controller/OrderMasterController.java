package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.OrderMaster;
import com.neusoft.springbootsell.exception.SellException;
import com.neusoft.springbootsell.services.OrderDetailService;
import com.neusoft.springbootsell.services.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/seller/order")
public class OrderMasterController {
    @Autowired
    private OrderMasterService orderMasterService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5")Integer size,
                             Map<String, Object> map){

        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<OrderMaster> orderMasterPage = orderMasterService.findAll(pageRequest);
        map.put("orderMasterPage", orderMasterPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new  ModelAndView("order/list", map);
    }


    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId")String orderId,Map<String,Object> map){
        try {
            OrderMaster orderMaster = orderMasterService.findOne(orderId);
            map.put("orderMaster",orderMaster);
            return new ModelAndView("order/index",map);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/seller/order/list");
            return new ModelAndView("common/error",map);
        }
    }


    @GetMapping("/cancel")
    public ModelAndView cancle(@RequestParam("orderId")String orderId,Map<String,Object> map){
        try {
            orderMasterService.cancel(orderId);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/seller/order/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/finsh")
    public ModelAndView finsh(@RequestParam("orderId")String orderId,Map<String,Object> map){
        try {
            orderMasterService.finsh(orderId);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/seller/order/list");
        return new ModelAndView("common/success",map);
    }


}
