package com.ordersystem.vo;

import lombok.Data;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 22:34:39 2021-03-17
 * @ClassName: ResultVo
 * @Description:  http请求返回的最外层对象【页面json中显示的对象】
 * @Version: 1.0
 */
@Data
public class ResultVo<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 返回的具体内容. */
    private T data;//定义为一个泛型【注意定义泛型时,要在类名上添加泛型】

}
