package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lingxiao
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface IPaymentFeignService {

    /**
     *  查询
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") long id);


    @GetMapping(value = "/payment/get/feignTimeout")
    CommonResult<String>  getFeignTimeout();

}
