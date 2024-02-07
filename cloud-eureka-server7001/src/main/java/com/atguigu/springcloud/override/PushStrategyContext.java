package com.atguigu.springcloud.override;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class PushStrategyContext {


    @Autowired
    private Map<String, AbstractPushMessage> pushMessageMap;

    public AbstractPushMessage getPushMessage(String businessCode, String pushChannelCode) {
        return pushMessageMap.get(businessCode + pushChannelCode);
    }

    @PostConstruct
    public void pushStrategyContext() {
        Map<String, AbstractPushMessage> pushMessageMapTemp = new HashMap<>(pushMessageMap.size());
        pushMessageMap.forEach((k, v) -> {
            pushMessageMapTemp.put(v.getBusinessCode() + v.pushChannelCode(), v);
        });
        pushMessageMap = pushMessageMapTemp;
    }

}
