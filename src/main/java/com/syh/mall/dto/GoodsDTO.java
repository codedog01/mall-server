package com.syh.mall.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>description goes here</p>
 *
 * @date 2022/2/3
 */
@Data
public class GoodsDTO {
    private Long id;

    @ApiModelProperty(value = "发布人openId")
    private String openId;

    @ApiModelProperty(value = "商品描述")
    private String describle;

    @ApiModelProperty(value = "商品名")
    private String name;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "状态，上架 下架")
    private Boolean status;

    @ApiModelProperty(value = "类型")
    private String type;

    private String updateTime;
}
