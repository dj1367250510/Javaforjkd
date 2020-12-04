package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import com.neusoft.springbootsell.dataobject.OrderMaster;
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

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/order")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderMasterService orderMasterService;

    @GetMapping("/detail/list")
    public ModelAndView list(@RequestParam String orderId,
                             Map<String, Object> map){

        OrderMaster master = orderMasterService.findOne(orderId);
        map.put("orderMaster", master);
        List<OrderDetail>  orderDetailList = orderDetailService.findByOrderId(orderId);
        map.put("orderDetailList",orderDetailList);
        return new  ModelAndView("order/index", map);
    }

}
