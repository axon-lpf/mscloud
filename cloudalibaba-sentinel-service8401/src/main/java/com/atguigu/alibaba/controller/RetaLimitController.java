package com.atguigu.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.alibaba.myhandler.CustomerBlockHandler;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetaLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return  new CommonResult(200,"按照资源名称限流0K",new Payment(2020L,"serial001"));
    }

    public  CommonResult handleException(BlockException exception ){
        return new CommonResult ( 444,exception.getClass(). getCanonicalName ()+ " \t 服务不可用 " );
    }


    @GetMapping ( "/retaLimit/byUrl" )
    @SentinelResource ( value="byUrl" )
    public CommonResult byUrl () {
        return new CommonResult(200, " 按 url 限流测试 OK", new Payment(2020L, "serial002"));
    }


    /**
     *  指定了流控名称，则必须按照流控规则流控名称来，不能按照路径
     *  指定了CustomerBlockHandler  中的handlerException2 的方法做为兜底方法
     * @return
     */
    @GetMapping ( "/rateLimit/customerBlockHandler" )
    @SentinelResource ( value = "customerBlockHandler" , blockHandlerClass = CustomerBlockHandler.class , blockHandler = "handlerException2" )
    public CommonResult customerBlockHandler () {
        return new CommonResult(200, " 按客戶自定义 ", new Payment(2020L, "serial003"));
    }


}
