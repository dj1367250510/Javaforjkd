package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import com.neusoft.springbootsell.repository.OrderDetailRepository;
import com.neusoft.springbootsell.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository repository;

    @Override
    public OrderDetail findOne(String orderId) {
        return repository.findOne(orderId);
    }

    @Override
    public List<OrderDetail> findByOrderId(String orderId) {
        return repository.findByOrderId(orderId);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }
}
