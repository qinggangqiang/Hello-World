package com.ordersystem.service;

import com.ordersystem.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 22:58:15 2021-03-16
 * @ClassName: ProductService
 * @Description: 商品
 * @Version: 1.0
 */

public interface ProductService {

    /** 通过ProductId来查询一条商品. */
    ProductInfo findOne(String productId);

    /** 查询全部上架的商品列表. */
    List<ProductInfo> findUpAll();

    /** 管理端：直接查询所有的商品【不管上不上架】 */
    /** 注意：在管理端,是要做一个分页查询,不可能全部查出所有商品;
     *       其中；传Pageable时导入这个包org.springframework.data.domain.Pageable;
     *            那返回的参数就不是list集合了，而是page的集合
     *  */
    Page<ProductInfo> findAll(Pageable pageable);

    /** save方法 */
    ProductInfo save(ProductInfo productInfo);

    //----------------------下订单的方法 start-----------------------
    /** 加库存. */


    /** 减库存. */

    //----------------------下订单的方法 END -------------------------


}
