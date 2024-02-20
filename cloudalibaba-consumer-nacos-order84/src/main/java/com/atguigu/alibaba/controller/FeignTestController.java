package com.atguigu.alibaba.controller;

import com.atguigu.alibaba.service.PaymentService;
import com.atguigu.springlcoud.alibaba.entities.CommonResult;
import com.atguigu.springlcoud.alibaba.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignTestController {
    @Resource
    private PaymentService paymentService;

    @GetMapping( value="/consumer/paymentSQL/{id}" )
    public CommonResult<Payment> paymentSQL (@PathVariable( "id" )Long id) {
        return paymentService.paymentSQL(id);}

}
