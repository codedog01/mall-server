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
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ${author}
 * @since 2022-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Worker对象", description = "用户表")
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "code")
    private String workerCode;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "姓别")
    private Boolean sex;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "状态（0失效，1启用，2冻结）")
    private Integer state;

    @ApiModelProperty(value = "登录次数")
    private Integer loginNum;

    @ApiModelProperty(value = "最后登录时间")
    private LocalDate lastLoginTime;

    @ApiModelProperty(value = "最后修改密码时间")
    private LocalDate lastChgPwdTime;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
