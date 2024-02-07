package com.atguigu.springcloud.override.business;

import com.atguigu.springcloud.override.AbstractMqttPushMessage;
import org.springframework.stereotype.Service;


@Service
public class PosMqttPushMessage extends AbstractMqttPushMessage {


    @Override
    public String getBusinessCode() {
        return "pos_mqtt";
    }

}
