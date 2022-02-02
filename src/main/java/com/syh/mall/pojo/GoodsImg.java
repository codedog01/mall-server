package com.syh.mall.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2022-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "GoodsImg对象", description = "")
public class GoodsImg implements Serializable {

    @ApiModelProperty(value = "Id")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "动态Id")
    private Long goodsId;

    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

    @ApiModelProperty(value = "上传时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime uploadTime;

    @ApiModelProperty(value = "排序")
    private Integer sort;


}
