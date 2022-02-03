package com.syh.mall.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>description goes here</p>
 *
 * @date 2022/2/3
 */
@Data
public class OrderDTO {
    private Long id;

    private String buyer;

    private String seller;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private Integer money;
}
