package com.ordersystem.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 23:06:19 2021-03-17
 * @ClassName: ProductInfoVo
 * @Description: 商品的详情【页面json中显示的对象】
 * @Version: 1.0
 */
@Data
public class ProductInfoVo {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
