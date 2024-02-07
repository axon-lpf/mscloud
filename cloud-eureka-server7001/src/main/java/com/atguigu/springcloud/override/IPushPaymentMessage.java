package com.atguigu.springcloud.override;


public interface IPushPaymentMessage extends IPushMessage {

    <T extends BaseDTO> void pushPaymentMessage(T t);

}
