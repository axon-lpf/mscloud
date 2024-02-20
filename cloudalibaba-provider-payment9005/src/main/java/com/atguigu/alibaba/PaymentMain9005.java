package com.atguigu.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


    @EnableDiscoveryClient
    @SpringBootApplication
    public class PaymentMain9005 {
        public static void main(String[] args) {
            SpringApplication.run(PaymentMain9005.class, args);
        }
    }
