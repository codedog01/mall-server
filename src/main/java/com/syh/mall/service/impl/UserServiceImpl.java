package com.syh.mall.service.impl;

import com.syh.mall.dto.UserDTO;
import com.syh.mall.pojo.User;
import com.syh.mall.mapper.UserMapper;
import com.syh.mall.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.UserVO;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @since 2022-02-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;
    
    @Override
    public UserVO login(UserDTO userDTO) {
        String openId = userDTO.getOpenId();
        User user = userMapper.selectByOpenId(openId);
        UserVO userVO = new UserVO();
        if (null == user) {
            user = new User();
            BeanUtils.copyProperties(userDTO, user);
            userMapper.insert(user);

        }
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
