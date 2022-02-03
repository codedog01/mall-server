package com.syh.mall.mapper;

import com.syh.mall.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @since 2022-02-03
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User selectByOpenId(String openId);
}
