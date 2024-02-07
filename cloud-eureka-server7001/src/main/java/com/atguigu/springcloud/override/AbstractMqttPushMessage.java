package com.atguigu.springcloud.override;


public abstract class AbstractMqttPushMessage extends AbstractPushMessage {

    @Override
    public <T extends BaseDTO> void pushPaymentMessage(T t) {
        System.out.println("mqtt 收款推送");
    }

    @Override
    public <T extends BaseDTO> void pushRefundMessage(T t) {
        System.out.println("mqtt 退款推送");
    }

    @Override
    public <T extends BaseDTO> void pushEvasionMessage(T t) {
        System.out.println("mqtt 逃单推送");
    }


    @Override
    public String pushChannelCode() {
        return "mqtt";
    }
}
