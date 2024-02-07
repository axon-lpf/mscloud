package com.atguigu.springcloud;

import com.atguigu.springcloud.override.AbstractPushMessage;
import com.atguigu.springcloud.override.BaseDTO;
import com.atguigu.springcloud.override.PushStrategyContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaMain7001.class)
public class SpringTest {

    @Autowired
    private PushStrategyContext pushStrategyContext;

    @Test
    public void test() {
        AbstractPushMessage pushMessage = pushStrategyContext.getPushMessage("pos_jg", "jg");
        pushMessage.pushPaymentMessage(new BaseDTO());
        pushMessage.pushRefundMessage(new BaseDTO());
        pushMessage.pushEvasionMessage(new BaseDTO());

        pushMessage = pushStrategyContext.getPushMessage("pos_mqtt", "mqtt");
        pushMessage.pushPaymentMessage(new BaseDTO());
        pushMessage.pushRefundMessage(new BaseDTO());
        pushMessage.pushEvasionMessage(new BaseDTO());
    }
}
