package com.atguigu.springcloud.override;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = -133128440605692004L;

    private Long id;

    private Boolean deleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
