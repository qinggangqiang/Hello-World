package com.ordersystem.service.impl;

import com.ordersystem.dao.ProductCategoryDao;
import com.ordersystem.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 22:21:42 2021-03-10
 * @ClassName: CategoryServiceImplTest
 * @Description: TODO
 * @Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryServiceimpl;//注意选择其实现类

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryServiceimpl.findOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());

    }

    @Test
    public void findAll() {

        List<ProductCategory> productCategoryList = categoryServiceimpl.findAll();
        //如果返回的list的长度不为0的话，则查询成功
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> productCategoryList = categoryServiceimpl.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0, productCategoryList.size());

    }

    @Test
    public void save() {

        ProductCategory productCategory = new ProductCategory("男生专享",10);
        ProductCategory result = categoryServiceimpl.save(productCategory);
        Assert.assertNotNull(result);

    }
}