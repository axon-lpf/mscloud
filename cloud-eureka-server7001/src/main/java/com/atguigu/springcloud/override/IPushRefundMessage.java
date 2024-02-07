package com.atguigu.springcloud.override;


public interface IPushRefundMessage extends IPushMessage {

    <T extends BaseDTO> void pushRefundMessage(T t);
}
