package com.syh.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syh.mall.dto.DynamicDTO;
import com.syh.mall.mapper.DynamicMapper;
import com.syh.mall.pojo.Dynamic;
import com.syh.mall.service.IDynamicService;
import com.syh.mall.vo.DynamicVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2022-02-03
 */
@Service
public class DynamicServiceImpl extends ServiceImpl<DynamicMapper, Dynamic> implements IDynamicService {
    @Autowired
    DynamicMapper dynamicMapper;

    @Override
    public void addDynamic(DynamicDTO dynamicDTO) {
        Dynamic dynamic = new Dynamic();
        BeanUtils.copyProperties(dynamicDTO, dynamic);
        dynamicMapper.insert(dynamic);
    }

    @Override
    public List<DynamicVO> selectAll(DynamicDTO dynamicDTO) {
        return dynamicMapper.selectList(new QueryWrapper<>()).stream().map(item -> {
            DynamicVO dynamicVO = new DynamicVO();
            BeanUtils.copyProperties(item, dynamicVO);
            return dynamicVO;
        }).collect(Collectors.toList());
    }
}
