package com.syh.mall.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>description goes here</p>
 *
 * @date 2022/2/3
 */
@Data
public class DynamicVO {
    private Long id;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "打卡内容")
    private String content;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
}
