package com.syh.mall.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>description goes here</p>
 *
 * @date 2022/2/3
 */
@Data
public class WorkerDTO {
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
    private LocalDateTime createTime;
}
