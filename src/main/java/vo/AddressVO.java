package vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>description goes here</p>
 *
 * @date 2022/2/3
 */
@Data
public class AddressVO {

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
