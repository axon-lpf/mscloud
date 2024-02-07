package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "order_Global_FallbackMethod")
public class OrderController {

    @Resource
    private PaymentHystrixService pyPaymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return pyPaymentHystrixService.paymentInfo_OK(id);
    }

    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})*/
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int age=10/0;
        return pyPaymentHystrixService.paymentInfo_TimeOut(id);
    }

    /**
     * 兜底服务
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "我是消费者80：调用支付接口超时或异常:" + "当前线程池名字" + Thread.currentThread().getName();
    }

    public  String order_Global_FallbackMethod(){
        return "全局异常信息处理，请稍后再试";
    }


}
