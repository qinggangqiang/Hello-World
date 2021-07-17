package com.ordersystem.service.impl;

import com.ordersystem.dataobject.ProductInfo;
import com.ordersystem.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 23:35:11 2021-03-16
 * @ClassName: ProductServiceImplTest
 * @Description: TODO
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo info = productService.findOne("123456");
        Assert.assertEquals("123456", info.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        Assert.assertNotEquals(0, upAll.size());
    }

    @Test
    public void findAll() {
        //首先构造pageable对象:PageRequest继承了AbstractPageRequest抽象类,而这个抽象类实现了pageable接口
//        PageRequest request = new PageRequest(0, 2);//方法过时
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> all = productService.findAll(request);
//        System.out.println(all.getTotalElements());
        Assert.assertNotEquals(0,all.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));//价格的数据类型一定是BigDecimal类型
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的虾");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());//0:正常
        productInfo.setCategoryType(2);//关联字段：找数据库中已经存在的值

        ProductInfo save = productService.save(productInfo);
        Assert.assertNotNull(save);
    }
}