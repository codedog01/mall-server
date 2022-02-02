package com.syh.mall.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@ApiModel(value = "Address对象", description = "")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String openId;

    private String userName;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区县")
    private String counties;

    @ApiModelProperty(value = "细节")
    private String detail;

    @ApiModelProperty(value = "默认地址")
    private Boolean isDefault;


}
