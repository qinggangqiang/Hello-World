package com.ordersystem.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 22:55:20 2021-03-17
 * @ClassName: ProductVo
 * @Description: 商品(包含类目)【页面json中显示的对象】
 * @Version: 1.0
 */
@Data
public class ProductVo {

//    private String name;//避免名字混淆,加个注解替换name
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoyrType;

    //tip:foods是一个list,list的里面又包含对象,注意这里面的字段虽然和productInfo的很像,但比较发现页面中显示的很少！那为什么不能使用productInfo这个对象呢？原因是：原则上前端需要几个字段就返回几个字段！出于安全和隐私的考虑！
    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;

}
