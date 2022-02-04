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
public class GoodsImgDTO {
    private Long id;

    private Long goodsId;

    private String imgBase64;

    private Integer sort;
}
