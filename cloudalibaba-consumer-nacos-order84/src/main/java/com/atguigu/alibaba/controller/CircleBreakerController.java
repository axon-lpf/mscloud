package com.atguigu.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springlcoud.alibaba.entities.CommonResult;
import com.atguigu.springlcoud.alibaba.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") // 没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback 只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler 只负责 sentinel 控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常 ....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 该 ID 没有对应记录 , 空指针异常 ");
        }

        return result;
    }

    //fallback
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, " 兜底异常 handlerFallback,exception 内容   " + e.getMessage(), payment);
    }

    //blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445, "blockHandler-sentinel 限流 , 无此流水 : blockException  " + blockException.getMessage(), payment);
    }
}
