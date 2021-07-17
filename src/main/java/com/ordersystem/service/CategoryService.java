package com.ordersystem.service;

import com.ordersystem.dataobject.ProductCategory;

import java.util.List;
import java.util.Locale;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 22:03:08 2021-03-10
 * @ClassName: CategoryService
 * @Description: 类目
 * @Version: 1.0
 */
public interface CategoryService {

    /** 查询一条记录. */
    ProductCategory findOne(Integer categoryId);

    /** 查询所有. */
    List<ProductCategory> findAll();

    //买家端
    /**  */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /** 新增. */
    ProductCategory save(ProductCategory productCategory);


}
