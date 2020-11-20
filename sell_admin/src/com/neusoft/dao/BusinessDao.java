package com.neusoft.dao;

import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessDao {
    //所有商家列表
    public List<Business> listBusiness();
    //保存商家   保存商家时自动生成的那个主键id
    public int saveBusiness(String businessName);
    //删除商家
    public int removeBusiness(String businessName);
    //修改商家
    public int updateBusiness(Business business);
    //通过ID查询
    public Business getBusinessById();

}