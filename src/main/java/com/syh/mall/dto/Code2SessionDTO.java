package com.syh.mall.dto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @date 2021/10/17 12:34
 */
@Data
public class Code2SessionDTO {
    @ApiModelProperty(" 用户唯一标识")
    @JSONField(defaultValue = "openid")
    String openId;

    @ApiModelProperty(" 会话密钥")
    @JSONField(defaultValue = "session_key")
    String sessionKey;

    @ApiModelProperty(" 用户在开放平台的唯一标识符 若当前小程序已绑定到微信开放平台帐号下会返回 详见 UnionID 机制说明。")
    @JSONField(defaultValue = "unionid")
    String unionId;

    @ApiModelProperty(" 错误码")
    @JSONField(defaultValue = "errcode")
    Integer errCode;

    @ApiModelProperty(" 错误信息")
    @JSONField(defaultValue = "errmsg")
    String errMsg;
}
