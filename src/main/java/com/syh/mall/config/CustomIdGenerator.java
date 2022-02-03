package com.syh.mall.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.syh.mall.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Component;

/**
 * @date 2021/10/20 8:44
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        //返回生成的id值即可.
        return SnowflakeIdWorker.generateId();
    }
}