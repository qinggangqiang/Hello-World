package com.ordersystem.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 21:36:33 2021-03-08
 * @ClassName: ProductCategory
 * @Description: 类目表
 * @Version: 1.0
 */

//javax.persistence.*的包都是jpa的依赖引入的

@Entity//@Entity：作用是将数据库表映射成对象
@Proxy(lazy = false)//如果不加此注解：在查询数据库数据时抛出异常org.hibernate.LazyInitializationException: could not initialize proxy
@DynamicUpdate//动态更新
@Data//自动生成getter/setter方法以及tostring()方法
public class ProductCategory {

    /** 类名id. */
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增类型的,必须加括号类的策略,不然在插入SQL语句时报错
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 创建时间. */
//    private Date createTime;//在数据库中创建时间的类型是:timestamp

    /** 修改时间. */
//    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
