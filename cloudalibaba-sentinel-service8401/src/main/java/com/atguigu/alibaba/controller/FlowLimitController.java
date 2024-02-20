package com.atguigu.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "----testB";
    }


    @GetMapping("/testC")
    public String testC() throws InterruptedException {
        Thread.sleep(3000);
        return "----testC";
    }

    /**
     * 用于RT测试
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        Thread.sleep(1000);
        return "----testD";
    }

    /**
     *  异常比例测试
     * @return
     */
    @GetMapping("/testE")
    public String testE() {
        int age = 10 / 0;
        return "----testE";
    }


    /**
     *  异常数测试
     * @return
     */
    @GetMapping("/testF")
    public String testF() {
        int age = 10 / 0;
        return "----testF";
    }


    /**
     *  用于热点参数测试
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        //int age = 10/0;
        return "------testHotKey";
    }

    //兜底方法
    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "------deal_testHotKey,o(╥ ﹏ ╥)o";
    }


}
