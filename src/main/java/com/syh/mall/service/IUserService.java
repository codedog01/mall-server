package com.syh.mall.service;

import com.syh.mall.dto.UserDTO;
import com.syh.mall.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.syh.mall.vo.UserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-02-03
 */
public interface IUserService extends IService<User> {

    UserVO login(UserDTO userDTO);
}
