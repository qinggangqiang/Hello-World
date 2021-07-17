package com.ordersystem;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: qinggangqiang
 * @Email: 18609482790@163.com
 * @Company: qinggangqiang
 * @Date: Created in 20:22:52 2021-03-07
 * @ClassName: LoggerTest
 * @Description: TODO
 * @param：LoggerTest
 * @Return:
 * @Version: 1.0
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j//是lombok依赖中的
public class LoggerTest {

    //要写日志的话需要引入一个类
    //private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
        String name = "qinggangqiang";
        String age = "26";
//        logger.debug(" debug... ");
//        logger.info(" info... ");
//        logger.error(" error... ");
        log.debug(" debug... ");
        log.info(" info... ");
        log.error(" error... ");
        //等价写法
        log.info(" name = " + name + " age =  " + age);
        log.info(" name = {}, age = {} ",name,age);
    }
}
