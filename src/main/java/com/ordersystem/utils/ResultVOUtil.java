package com.ordersystem.utils;

import com.ordersystem.vo.ResultVo;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 23:07:00 2021-03-18
 * @ClassName: ResultVOUtil
 * @Description: 返回页面的数据封装
 * @Version: 1.0
 */
public class ResultVOUtil {

    //返回成功【传参数】
    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setData(object);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return  resultVo;
    }

    //返回成功【无参】
    public static ResultVo success(){
        return success(null);
    }

    //失败
    public static ResultVo error(Integer code,String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
