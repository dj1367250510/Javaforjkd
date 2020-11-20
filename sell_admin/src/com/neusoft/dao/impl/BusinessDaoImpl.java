package com.neusoft.dao.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.domain.Business;
import com.neusoft.untils.JDBCUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public List<Business> listBusiness() {
        ArrayList<Business> list = new ArrayList<>();
        String sql = "select * from business";
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Business business = new Business();
                Integer businessId = rs.getInt(1);
                String password =rs.getString(2);
                String businessName = rs.getString(3);
                String businessAddress =rs.getString(4);
                String businessExplain = rs.getString(5);
                Double starPrice =rs.getDouble(6);
                Double deliveryPrice =rs.getDouble(7);
                business.setBusinessId(businessId);
                business.setPassword(password);
                business.setBusinessName(businessName);
                business.setBusinessAddress(businessAddress);
                business.setBusinessExplain(businessExplain);
                business.setStarPrice(starPrice);
                business.setDeliveryPrice(deliveryPrice);
                list.add(business);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int saveBusiness(String businessName) {
        int businessId = 0;
        //希望插入商家的时候自动给一个默认密码
        String sql = "insert into business(businessName,password) values (?,'123')";
        try{
            conn = JDBCUtils.getConnection();
            //要设置返回自增长键
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1,businessName);
            pst.executeUpdate();
            //同时获取自增长的ID值 一行一列
            rs = pst.getGeneratedKeys();
            if(rs.next()){
               businessId = rs.getInt(1);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pst,conn);
        }
        return businessId;
    }

    @Override
    public int removeBusiness(String businessName) {
        return 0;
    }

    @Override
    public int updateBusiness(Business business) {
        return 0;
    }

    @Override
    public Business getBusinessById() {
        return null;
    }

}
