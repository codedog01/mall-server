package com.syh.mall.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>description goes here</p>
 *
 * @date 2022/2/3
 */
@Data
public class UserDTO {
    private Long id;

    @ApiModelProperty("校验code码")
    private String code;

    @ApiModelProperty(value = "第三方appid")
    private String appId;

    @ApiModelProperty(value = "同个第三方下不同应用之间的唯一标记")
    private String openId;

    @ApiModelProperty(value = "帐号状态 1:启用  2:禁用")
    private Boolean state;

    @ApiModelProperty(value = "用户名")
    private String nickName;

    @ApiModelProperty(value = "手机号")
    private String mobilePhone;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "卖出的数量")
    private Integer sellNum;
}
