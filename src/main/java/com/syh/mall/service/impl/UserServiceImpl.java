package com.syh.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syh.mall.pojo.User;
import com.syh.mall.mapper.UserMapper;
import com.syh.mall.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.syh.mall.vo.UserVO;

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
    public UserVO login(String openId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId);
        User user = userMapper.selectOne(queryWrapper);
        UserVO userVO = new UserVO();
        if (null == user) {
            user = new User();
            user.setOpenId(openId);
            userMapper.insert(user);
        }
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
