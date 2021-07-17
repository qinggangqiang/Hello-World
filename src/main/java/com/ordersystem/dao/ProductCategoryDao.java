package com.ordersystem.dao;

import com.ordersystem.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 22:08:53 2021-03-08
 * @ClassName: ProductCategoryDao
 * @Description: TODO
 * @Version: 1.0
 */
//dao层接口继承JpaRepository<ProductCategory,Integer>，第一个参数是实体类，第二个参数是主键的引用类型

public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {



    //到时候再查询商品的时候,查商品列表,先查出来商品,然后再来查询类目,肯定是希望一次性查到！而不是分很多次查询
    //而且是通过categoryType【类目的编号】来查询的：也就是通过categoryType的list来查类目
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);//写测试方法进行测试



}
