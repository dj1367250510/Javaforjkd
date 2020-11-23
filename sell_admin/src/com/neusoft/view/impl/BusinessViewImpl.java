package com.neusoft.view.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {
    private Scanner input = new Scanner(System.in);
    //显示全部
    @Override
    public void listAllBusiness() {
        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号"+"\t"+"商家名称"+"\t"+"商家地址"+"\t"+"商家备注"+"\t"+"商家起送费"+"\t"+"商家配送费");
        for (Business b :list){
            System.out.println(b.getBusinessId() +"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getStarPrice()+"\t"+b.getDeliveryPrice());
        }
    }
    //搜索
    @Override
    public void selectBusiness(){
        String businessName = "";
        String inputStr = "";
        String businessAddress = "";
        System.out.println("请输入是否输入商家名称关键词(y/n):");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入商家名称关键词");
            businessName = input.next();
        }

        System.out.println("请输入是否输入商家地址关键词(y/n):");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入商家地址关键词");
            businessAddress = input.next();
        }
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号"+"\t"+"商家名称"+"\t"+"商家地址"+"\t"+"商家备注"+"\t"+"商家起送费"+"\t"+"商家配送费");
        for (Business b :list){
            System.out.println(b.getBusinessId() +"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getStarPrice()+"\t"+b.getDeliveryPrice());
        }
    }
    //新增
    @Override
    public void saveBusiness() {
        System.out.println("请输入新商家的名称：");
        String businessName = input.next();
        BusinessDao dao = new BusinessDaoImpl();
        int businessId = dao.saveBusiness(businessName);
        //根据id进行查询，然后进行回写
        if(businessId > 0){
            System.out.println("保存成功！");
            Business business = dao.getBusinessById(businessId);
            System.out.println(business);
        }else{
            System.out.println("保存失败！");
        }
    }
    //删除
    @Override
    public void removeBusiness() {
        System.out.println("请输入要删除商家的id号：");
        int id = input.nextInt();
        BusinessDao dao = new BusinessDaoImpl();
        System.out.println("确认要删除吗（y/n）");
        if(input.next().equals("y")){
            int i = dao.removeBusiness(id);
            if(i==1){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }
        }
    }

    @Override
    public Business login() {
        System.out.println("请输入商家编号：");
        Integer businessId = input.nextInt();

        System.out.println("请输入密码：");
        String password= input.next();

        BusinessDaoImpl dao = new BusinessDaoImpl();
        return dao.getBusinessByIdAndPassword(businessId,password);
    }

    @Override
    public void showBusiness(Integer businessId) {
        BusinessDao dao = new BusinessDaoImpl();
        Business business = dao.getBusinessById(businessId);
        System.out.println(business);
    }

    @Override
    public void updateBusiness(Integer businessId) {
        //先看下然后再根据看得修改
        BusinessDao dao = new BusinessDaoImpl();
        Business business = dao.getBusinessById(businessId);
        System.out.println(business);
        //开始修改  为了满足有的修改有的不修改就不沿用之前老师讲的全部修改的那个代码了
        String inputStr = " ";
        System.out.println("是否修改商家名称(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的商家名称：");
            business.setBusinessName(input.next());
        }

        System.out.println("是否修改商家地址(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的商家地址：");
            business.setBusinessAddress(input.next());
        }

        System.out.println("是否修改商家介绍(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的商家介绍：");
            business.setBusinessExplain(input.next());
        }

        System.out.println("是否修改起送费(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的起送费：");
            business.setStarPrice(input.nextDouble());
        }

        System.out.println("是否修改配送费(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的配送费：");
            business.setDeliveryPrice(input.nextDouble());
        }

        int result = dao.updateBusiness(business);
        if(result>0) {
            System.out.println("\n修改商家信息成功！\n");
        }else {
            System.out.println("\n修改商家信息失败！\n");
        }
    }

    @Override
    public void updatePassword(Integer businessId) {
        BusinessDao dao = new BusinessDaoImpl();
        Business business = dao.getBusinessById(businessId);
        System.out.println("请输入旧密码");
        String oldPassword = input.next();
        System.out.println("请输入新密码");
        String newPassword = input.next();
        System.out.println("请再次输入新密码");
        String beginnewPassword = input.next();
        //进行密码校验
        if(!business.getPassword().equals(oldPassword)){
            System.out.println("你的密码错误，请重新输入");
        }else if(!newPassword.equals(beginnewPassword)){
            System.out.println("两次密码不一致，请重新输入");
        }else{
          int res = dao.updateBusinessPassword(businessId,newPassword);
          if(res>0){
              System.out.println("修改密码成功！");
          }else{
              System.out.println("修改密码失败！");
          }
        }
    }
}
