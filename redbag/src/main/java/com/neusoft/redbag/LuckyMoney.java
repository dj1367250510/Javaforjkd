package com.neusoft.redbag;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * LuckyMoney  是与数据库表中字段一一对应得实体类
 */
@Entity
@Data
public class LuckyMoney {
    //@Entity指定该类是实体类  @Id  代表主键  @GeneratedValue 代表自增长
    @Id
    @GeneratedValue
    private Integer id;
    //红包金额
    private BigDecimal money;
    //发红包的人
    private String producer;
    //收红包的人
    private String consumer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public LuckyMoney(){
    }


}
