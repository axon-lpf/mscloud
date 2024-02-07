package com.atguigu.springcloud.override.business;

import com.atguigu.springcloud.override.AbstractJgPushMessage;
import org.springframework.stereotype.Service;


@Service
public class AppJgPushMessage extends AbstractJgPushMessage {


    @Override
    public String getBusinessCode() {
        return "app_jg";
    }
}
