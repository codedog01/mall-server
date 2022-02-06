package com.syh.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>description goes here</p>
 *
 * @author 冷澳
 * @date 2021/12/11
 */
@Data
@ApiModel("头像上传")
public class UserAvatarDTO {

    @ApiModelProperty("用户openId")
    String openId;

    @ApiModelProperty("用户头像")
    MultipartFile avatarImage;
}
