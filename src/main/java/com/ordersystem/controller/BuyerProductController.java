package com.ordersystem.controller;

import com.ordersystem.dataobject.ProductCategory;
import com.ordersystem.dataobject.ProductInfo;
import com.ordersystem.service.CategoryService;
import com.ordersystem.service.ProductService;
import com.ordersystem.utils.ResultVOUtil;
import com.ordersystem.vo.ProductInfoVo;
import com.ordersystem.vo.ProductVo;
import com.ordersystem.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 22:15:53 2021-03-17
 * @ClassName: BuyerProductController
 * @Description: 买家商品
 * @Version: 1.0
 */
@RestController
@RequestMapping("/buyer/product")//注意URL前缀和类名很相似
public class BuyerProductController {

    @Autowired
    private ProductService productService;


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list(){
        //注意：查看API文档时,重点是要返回的数据
        //首先根据文档中的数据创建返回的对象,返回给前端的对象包名叫VO
        //(1)建立最外层的对象
        //(2)建立第二层的对象
        //---------------测试能否运行------------
//        ResultVo resultVo = new ResultVo();
//        ProductVo productVo = new ProductVo();
//        ProductInfoVo productInfoVo = new ProductInfoVo();
//
//        resultVo.setCode(0);
//        resultVo.setMsg("成功");
//
//        resultVo.setData(Arrays.asList(productVo));//注意此参数是list集合
//        productVo.setProductInfoVoList(Arrays.asList(productInfoVo));//注意此参数是个list集合
//
//        return resultVo;
        //-------------------------------------
        //---------------正式编码----------------
        //现在我们要从数据库中查数据并且要展示出来的操作：
        //1:查询所有的上架商品[此处没有使用到翻页]
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2:查询类目[只查需要的而不是所有的](注意：一定要一次性查询-为了性能的提升)
//        List<Integer> categoryTypeList = new ArrayList<>();
        //(1)传统方法
//        for (ProductInfo productInfo:productInfoList){
//            int categoryType = productInfo.getCategoryType();
//            categoryTypeList.add(categoryType);
//        }
        //(2)精简方法(利用Java8的特性:lambda表达式)
        List<Integer> integerList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(integerList);

        //3:数据拼装[从内往外封装]
        //(1)首先定义类目表
        List<ProductVo> productVoList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoyrType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());

            //(2)遍历商品详情
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                //先进行判断：再进行之后的操作
                if (productInfo.getCategoryType() == productCategory.getCategoryType()){//源码使用的是equals
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    //注意：如果一个一个的往productInfoVo set数据,比较多,换种写法[spring提供的]
                    //BeanUtils可以将一个对象里面的值copy到另外一个对象里面去
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);

                }

            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        //-------------------返回给页面的数据---------------------
//        ResultVo resultVo = new ResultVo();
//        resultVo.setCode(0);
//        resultVo.setMsg("成功");
//        resultVo.setData(productVoList);
//        return resultVo;//注意:在编码中不要将数据库的查询放到for循环当中去!一旦循环的数量过大,则时间开销是很大很大的!
        //------------------------------------------------------
        //-------------------优化返回给页面的数据---------------------
        //返回成功的数据
        return ResultVOUtil.success(productVoList);

    }

}
