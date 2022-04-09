package com.syh.mall.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>description goes here</p>
 *
 * @date 2022/2/3
 */
@Data
public class CommodityVO {

    private Label label;

    private List<Goods> goods;

    @Data
    public static class Label {
        String name;

        Long idx;
    }

    @Data
    public static class Goods {
        Long id;

        String openId;

        String describle;

        String name;

        Double price;

        Boolean status;

        String type;

        List<String> thumb;

        LocalDateTime updateTime;

        private Integer num;
    }
}
