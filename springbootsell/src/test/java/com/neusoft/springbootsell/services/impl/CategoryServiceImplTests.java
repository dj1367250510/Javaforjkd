package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTests {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne(){
        ProductCategory productCategory = categoryService.findOne(3);
        System.out.println(productCategory);
        Assert.assertEquals(new Integer(3),productCategory.getCategoryId());
    }

    @Test
    public void findAll(){
        List<ProductCategory> list = categoryService.findAll();
        for(ProductCategory productCategory : list){
            System.out.println(productCategory);
        }
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findByCategoryTypeIn(){
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(2,3,21));
        for(ProductCategory productCategory : list){
            System.out.println(productCategory);
        }
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void save(){
        ProductCategory category = new ProductCategory("炸鸡",3);
        ProductCategory productCategory = categoryService.save(category);
        Assert.assertNotNull(productCategory);
    }

}
