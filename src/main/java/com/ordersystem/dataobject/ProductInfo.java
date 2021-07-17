package com.ordersystem.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 21:54:33 2021-03-08
 * @ClassName: ProductInfo
 * @Description: 商品表
 * @Version: 1.0
 */
@Entity
@Data
public class ProductInfo {

    /** 商品id. */
    @Id//此表的主键
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品价格.涉及到价格的一定要将其类型设置为BigDecimal */
    private BigDecimal productPrice;

    /** 商品库存. */
    private int productStock;

    /** 商品描述. */
    private String productDescription;

    /** 商品小图. */
    private String productIcon;

    /** 商品状态,0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private int categoryType;

//    /** 创建时间. */
//    private Long createTime;
//
//    /** 修改时间. */
//    private Long updatTime;

}
