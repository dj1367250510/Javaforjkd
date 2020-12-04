package com.neusoft.springbootsell.services;



import com.neusoft.springbootsell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderMasterService {
    //查询一个商品
    OrderMaster findOne(String orderId);

    //分页查询所有订单
    Page<OrderMaster> findAll(Pageable pageable);

    //取消订单
    OrderMaster cancel(String orderId);

    //取消订单
    OrderMaster finsh(String orderId);
}
