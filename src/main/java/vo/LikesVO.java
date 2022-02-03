package vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>description goes here</p>
 *
 * @date 2022/2/3
 */
@Data
public class LikesVO {
    private Long id;

    private Long goodsId;

    private String openId;

}
