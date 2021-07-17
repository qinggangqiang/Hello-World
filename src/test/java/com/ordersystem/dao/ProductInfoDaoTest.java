package com.ordersystem.dao;

import com.ordersystem.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 22:59:38 2021-03-15
 * @ClassName: ProductInfoDaoTest
 * @Description: TODO
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    /** 测试新增的方法 */
    @Test
    public void saveTest(){

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));//价格的数据类型一定是BigDecimal类型
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);//0:正常
        productInfo.setCategoryType(2);//关联字段：找数据库中已经存在的值

        ProductInfo saveInfo = productInfoDao.save(productInfo);
        Assert.assertNotNull(saveInfo);
    }

    /** 查询测试上架商品. */
    @Test
    public void findByProductStatusTest(){

        List<ProductInfo> status = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0,status.size());

    }
}