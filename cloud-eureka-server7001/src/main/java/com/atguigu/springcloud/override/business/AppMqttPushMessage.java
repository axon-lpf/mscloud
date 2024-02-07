package com.atguigu.springcloud.override.business;

import com.atguigu.springcloud.override.AbstractMqttPushMessage;
import com.atguigu.springcloud.override.AbstractPushMessage;
import org.springframework.stereotype.Service;


@Service
public  class AppMqttPushMessage extends AbstractMqttPushMessage {


    @Override
    public String getBusinessCode() {
        return "app_mqtt";
    }


}
