package com.syh.mall.controller;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.syh.mall.dto.Code2SessionDTO;
import com.syh.mall.dto.UserDTO;
import com.syh.mall.enums.Code2SessionErrCode;
import com.syh.mall.service.IUserService;
import com.syh.mall.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vo.UserVO;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @since 2022-02-03
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Value("${wx.appId}")
    private String appId;
    @Value("${wx.secret}")
    private String secret;
    @Autowired
    IUserService userService;

    @GetMapping("/login")
    @ApiOperation("登录")
    public Result<UserVO> login(String code) {
        System.out.println("UserController.login");
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&grant_type=authorization_code&js_code=" + code;
        /*发送请求获取openid等信息*/
        Code2SessionDTO code2SessionDTO = JSON.parseObject(HttpUtil.createGet(url).execute().body(), Code2SessionDTO.class);
        /*根据返回值errcode来判断请求情况*/
        if (StringUtils.isNotBlank(code2SessionDTO.getOpenId())) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(code2SessionDTO, userDTO);
            userDTO.setCode(code);
            return Result.ofSuccess(userService.login(userDTO));
        }
        /*如果失败就获取到对应的失败信息并返回*/
        Code2SessionErrCode code2SessionErrCode = Code2SessionErrCode.getCode2SessionErrCode(code2SessionDTO.getErrCode());
        return Result.ofFail(code2SessionErrCode.getErrorCode(), code2SessionErrCode.getErrorMsg());
    }
}

