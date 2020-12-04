package com.neusoft.springbootsell.enums;

import lombok.Getter;
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NWE(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"取消"),
    ;
    private Integer code;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
