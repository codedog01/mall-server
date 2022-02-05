package com.syh.mall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syh.mall.mapper.GoodsTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @since 2022-02-03
 */
@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/test2")
    public String test2(){
        goodsTypeMapper.selectList(new QueryWrapper<>());
        return goodsTypeMapper.selectList(new QueryWrapper<>()).toString();
    }
}

