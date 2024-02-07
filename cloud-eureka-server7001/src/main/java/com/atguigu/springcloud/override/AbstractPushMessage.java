package com.atguigu.springcloud.override;


public abstract class AbstractPushMessage implements IPushPaymentMessage, IPushRefundMessage, IPushEvasionMessage {

    /**
     * 业务码
     * @return
     */
    public abstract String getBusinessCode();

    /**
     * 推送渠道
     * @return
     */
    public  abstract  String pushChannelCode();


}
