package com.ordersystem.service.impl;

import com.ordersystem.dao.ProductInfoDao;
import com.ordersystem.dataobject.ProductInfo;
import com.ordersystem.enums.ProductStatusEnum;
import com.ordersystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 23:12:20 2021-03-16
 * @ClassName: ProductServiceImpl
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    /** 通过ProductId来查询一条商品. */
    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.getOne(productId);
    }

    /** 查询全部上架的商品列表. */
    @Override
    public List<ProductInfo> findUpAll() {
        //注意:在代码中不要经常使用数字直接使用,而是使用枚举
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());//0上架
    }

    /** 管理端：直接查询所有的商品【不管上不上架】 */
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    /** save方法 */
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }
}
