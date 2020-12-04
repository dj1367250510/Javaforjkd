package com.neusoft.springbootsell.form;

import com.neusoft.springbootsell.enums.OrderStatusEnum;
import com.neusoft.springbootsell.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class OrderMasterForm {
    private String OrderId;

    //买家名字
    private String buyerName;

    //买家手机号
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家微信
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态  默认为0 为新下单
    private Integer orderStatus = OrderStatusEnum.NWE.getCode();

    //支付状态  默认为0 未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //订单创建时间
    private Date createTime;

    //订单更新时间
    private Date updateTime;

}
