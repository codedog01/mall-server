package com.syh.mall.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.syh.mall.pojo.GoodsImg;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>description goes here</p>
 *
 * @author 冷澳
 * @date 2022/2/6
 */
@Data
public class GoodsVO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "发布人openId")
    private String avatar;

    @ApiModelProperty(value = "发布人姓名")
    private String nickName;

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

    @ApiModelProperty(value = "数量")
    private Integer num;

    List<String> images;

    private String updateTime;
}
