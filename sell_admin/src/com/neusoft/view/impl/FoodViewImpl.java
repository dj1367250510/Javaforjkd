package com.neusoft.view.impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.dao.impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    private Scanner input = new Scanner(System.in);

    @Override
    public List<Food> showFoodList(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = dao.listFoodByBusinessId(businessId);
        System.out.println("食品编号\t食品名称\t食品介绍\t食品价格");
        for (Food food : list) {
            System.out.println(food.getFoodId() + "\t" + food.getFoodName() + "\t" + food.getFoodExplain() + "\t" + food.getFoodPrice());
        }
        return list;
    }

    @Override
    public void saveFood(Integer businessId) {
        Food food = new Food();
        System.out.println("请输入食品名称：");
        food.setFoodName(input.next());
        System.out.println("请输入食品介绍：");
        food.setFoodExplain(input.next());
        System.out.println("请输入食品价格：");
        food.setFoodPrice(input.nextDouble());
        food.setBusinessId(businessId);

        FoodDao dao = new FoodDaoImpl();
        int result = dao.saveFood(food);
        if (result > 0) {
            System.out.println("\n 恭喜您已增加成功！");
        } else {
            System.out.println("\n 很遗憾，您增加失败了！");
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        //先看下然后再根据看得修改
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = dao.listFoodByBusinessId(businessId);
        System.out.println("食品编号\t食品名称\t食品介绍\t食品价格");
        for (Food food : list) {
            System.out.println(food.getFoodId() + "\t" + food.getFoodName() + "\t" + food.getFoodExplain() + "\t" + food.getFoodPrice());
        }
        if (list.size() == 0) {
            System.out.println("无任何食品！");
        } else {
            System.out.println("您即将修改的食品的编号为：");
            int foodId = input.nextInt();
            Food food = dao.getFoodById(foodId);
            System.out.println(food);

            String inputStr = "";
            System.out.println("是否更新食品名称(y/n)：");
            inputStr = input.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品名称：");
                food.setFoodName(input.next());
            }

            System.out.println("是否更新食品介绍(y/n)：");
            inputStr = input.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品介绍：");
                food.setFoodExplain(input.next());
            }
            System.out.println("是否修改食品价格(y/n)：");
            inputStr = input.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品价格：");
                food.setFoodPrice(input.nextDouble());
            }

            int result = dao.updateFood(food);
            if (result > 0) {
                System.out.println("\n修改食品成功！\n");
            } else {
                System.out.println("\n修改食品失败！\n");
            }
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        //先看下整体再删除
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = dao.listFoodByBusinessId(businessId);
        System.out.println("食品编号\t食品名称\t食品介绍\t食品价格");
        for (Food food : list) {
            System.out.println(food.getFoodId() + "\t" + food.getFoodName() + "\t" + food.getFoodExplain() + "\t" + food.getFoodPrice());
        }
        if (list.size() == 0) {
            System.out.println("无任何食品！");
        } else {
            System.out.println("请选择要删除的食品的编号：");
            int foodId = input.nextInt();
            //给用户一个缓冲时间
            System.out.println("是否要删除吗(y/n)：");
            if (input.next().equals("y")) {
                int result = dao.removeFood(foodId);
                if (result > 0) {
                    System.out.println("\n您已删除成功！\n");
                } else {
                    System.out.println("\n很遗憾，删除失败！\n");
                }
            }
        }
    }
}
