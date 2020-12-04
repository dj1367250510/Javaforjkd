package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import java.util.List;

public interface OrderDetailService {
    OrderDetail findOne(String orderId);

    List<OrderDetail> findByOrderId(String orderId);

    OrderDetail save(OrderDetail orderDetail);


}
