package com.syh.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syh.mall.dto.UserAvatarDTO;
import com.syh.mall.dto.UserDTO;
import com.syh.mall.mapper.UserMapper;
import com.syh.mall.pojo.User;
import com.syh.mall.service.IUserService;
import com.syh.mall.utils.AliOSSUtils;
import com.syh.mall.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2022-02-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AliOSSUtils aliOSSUtils;

    @Override
    public UserVO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", userDTO.getOpenId());
        User user = userMapper.selectOne(queryWrapper);
        UserVO userVO = new UserVO();
        if (null == user) {
            user = new User();
            user.setOpenId(userDTO.getOpenId());
            userMapper.insert(user);
        }
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    @Override
    public void uploadAvatar(UserAvatarDTO userAvatarDTO) {
        String avatarUrl = aliOSSUtils.uploadAvatar(userAvatarDTO.getAvatarImage(), userAvatarDTO.getOpenId());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", userAvatarDTO.getOpenId());
        User userInfo = userMapper.selectOne(queryWrapper);
        userInfo.setAvatar(avatarUrl);
        userMapper.updateById(userInfo);
    }

    @Override
    public UserVO getUserInfo(String openId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId);
        User user = userMapper.selectOne(queryWrapper);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
