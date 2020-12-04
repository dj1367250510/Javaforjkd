package com.neusoft.springbootsell.services.impl;


import com.neusoft.springbootsell.dataobject.OrderMaster;
import com.neusoft.springbootsell.enums.OrderStatusEnum;
import com.neusoft.springbootsell.enums.ResultEnum;
import com.neusoft.springbootsell.exception.SellException;
import com.neusoft.springbootsell.repository.OrderMasterRepository;
import com.neusoft.springbootsell.services.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    private OrderMasterRepository repository;

    @Override
    public OrderMaster findOne(String orderId) {
        return repository.findOne(orderId);
    }

    @Override
    public Page<OrderMaster> findAll(Pageable pageable) {
        Page<OrderMaster> orderMasterPage = repository.findAll(pageable);
        return orderMasterPage;
    }

    @Override
    public OrderMaster cancel(String orderId) {
        //先查一下
        OrderMaster orderMaster = repository.findOne(orderId);
        if(orderMaster == null ){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if(orderMaster.getOrderStatus() == OrderStatusEnum.FINISH.getCode()){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        return repository.save(orderMaster);
    }

    @Override
    public OrderMaster finsh(String orderId) {
        //先查一下
        OrderMaster orderMaster = repository.findOne(orderId);
        if(orderMaster == null ){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if(orderMaster.getOrderStatus() == OrderStatusEnum.CANCEL.getCode()){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        orderMaster.setOrderStatus(OrderStatusEnum.NWE.getCode());
        return repository.save(orderMaster);
    }
}
