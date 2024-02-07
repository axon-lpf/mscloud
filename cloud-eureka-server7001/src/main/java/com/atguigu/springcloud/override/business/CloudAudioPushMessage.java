package com.atguigu.springcloud.override.business;

import com.atguigu.springcloud.override.AbstractMqttPushMessage;
import org.springframework.stereotype.Service;

@Service
public class CloudAudioPushMessage extends AbstractMqttPushMessage {


    @Override
    public String getBusinessCode() {
        return "cloud_mqtt";
    }
}
