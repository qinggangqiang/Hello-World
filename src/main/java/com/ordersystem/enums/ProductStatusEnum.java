package com.ordersystem.enums;

import lombok.Getter;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 23:19:09 2021-03-16
 * @ClassName: ProductStatusEnum
 * @Description: 商品状态
 * @Version: 1.0
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
