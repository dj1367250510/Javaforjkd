package com.neusoft;

import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.domain.Business;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        BusinessDaoImpl dao = new BusinessDaoImpl();

        //查询所有
//        List<Business> businessList = dao.listBusiness();
//        for (Business b : businessList) {
//            System.out.println(b);
//        }

        //增
//        int businessid = dao.saveBusiness("老八蜜汁小憨包");
//        System.out.println("id"+businessid);

        //删
//        dao.removeBusiness(10013);

        //改
//        Business business = new Business();
//        business.setBusinessName("闪电五连鞭");
//        business.setBusinessAddress("马保国道馆");
//        business.setBusinessExplain("混元太极门掌门人");
//        business.setStarPrice(18.0);
//        business.setDeliveryPrice(66.6);
//        business.setBusinessId(10012);
//        dao.updateBusiness(business);

//        //查
//        Business business =dao.getBusinessById(10012);
//        System.out.println(business);

    }

}
