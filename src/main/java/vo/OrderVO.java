package vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>description goes here</p>
 * @date 2022/2/3
 */
@Data
public class OrderVO {
    private Long id;

    private String buyer;

    private String seller;

    private LocalDateTime createTime;

    private Integer money;
}
