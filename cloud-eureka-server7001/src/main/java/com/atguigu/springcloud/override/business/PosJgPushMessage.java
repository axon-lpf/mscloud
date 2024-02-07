package com.atguigu.springcloud.override.business;

import com.atguigu.springcloud.override.AbstractJgPushMessage;
import com.atguigu.springcloud.override.AbstractPushMessage;
import org.springframework.stereotype.Service;


@Service
public  class PosJgPushMessage extends AbstractJgPushMessage {

    @Override
    public String getBusinessCode() {
        return "pos_jg";
    }
}
