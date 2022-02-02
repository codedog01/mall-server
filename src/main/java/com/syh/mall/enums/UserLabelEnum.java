package com.syh.mall.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author LengAo
 * @date 2021/10/20 9:25
 */
public class UserLabelEnum {


    UserLabelEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    @EnumValue//标记数据库存的值是code
    private  int code;

    private  String descp;
}
