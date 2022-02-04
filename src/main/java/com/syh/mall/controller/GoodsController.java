package com.syh.mall.controller;


import com.syh.mall.dto.GoodsDTO;
import com.syh.mall.service.IGoodsService;
import com.syh.mall.utils.Result;
import com.syh.mall.vo.CommodityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @since 2022-02-03
 */
@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    IGoodsService goodsService;


    @GetMapping("/selectAll")
    public Result<List<CommodityVO>> selectAll() {

        return Result.ofSuccess(goodsService.selectAll());
    }

    @PostMapping("/addGoods")
    public Result<Object> addGoods(GoodsDTO goodsDTO) {
        goodsService.addGoods(goodsDTO);
        return Result.ofSuccess();
    }

}

