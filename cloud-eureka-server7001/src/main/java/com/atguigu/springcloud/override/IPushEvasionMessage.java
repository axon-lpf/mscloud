package com.atguigu.springcloud.override;


public interface IPushEvasionMessage extends IPushMessage{

    <T extends BaseDTO> void pushEvasionMessage(T t);

}
