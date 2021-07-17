package com.ordersystem.dao;

import com.ordersystem.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 22:30:18 2021-03-08
 * @ClassName: ProductCategoryDaoTest
 * @Description: TODO
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test//注意：引入的包是import org.junit.Test;
    public void findOneTest(){
        //查询
        ProductCategory productCategory = productCategoryDao.getOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){
        //新增
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        productCategoryDao.save(productCategory);
    }

    @Test
    @Transactional//javax.transaction.Transactional;是jpa下面的事务与service下面的不同
    //service添加事务注解其作用是：在方法中如果抛出异常的话会发生回滚！
    //测试中添加事务注解其作用是：是完全的回滚数据
    public void updateTest(){
        //以后往往更新的时候,先要进行查询在更新！
        //(1)查询：比如是个用户的话,在更新一些用户名、密码等的属性时,首先要查询出来,然后在判断它的权限、资料是否正确,用户的状态是否正常/拉黑等系列操作！权限通过之后才会进行更新！
//        ProductCategory productCategory0 = productCategoryDao.getOne(2);
//        productCategory0.setCategoryType(3);
        ProductCategory productCategory = new ProductCategory("女生最爱", 4);
        //(2)更新
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertEquals(null, result);//第一个参数是不希望出现的，第二个参数是实际的
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3);
        //根据类目的编号集合去查询
        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(list);
        //判断其查询是否成功
        Assert.assertNotEquals(0, result.size());
    }
}