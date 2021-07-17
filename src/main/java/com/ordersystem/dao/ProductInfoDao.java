package com.ordersystem.dao;

import com.ordersystem.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 22:51:25 2021-03-15
 * @ClassName: ProductInfoDao
 * @Description: TODO
 * @Version: 1.0
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {

    /** 查询上架的商品,通过商品的状态来查 */
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
