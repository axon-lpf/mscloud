package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "支付异常啊啊啊啊-paymentInfo_OK ";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "支付超时啦啦啦啦啦啦啦啦-paymentInfo_TimeOut";
    }
}
