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
public class GoodsImgVO {
    private Long id;

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "动态Id")
    private Long goodsId;

    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

    @ApiModelProperty(value = "上传时间")
    private LocalDateTime uploadTime;

    @ApiModelProperty(value = "排序")
    private Integer sort;
}
