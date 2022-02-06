package com.syh.mall.controller;


import com.syh.mall.dto.LikesDTO;
import com.syh.mall.dto.UserAvatarDTO;
import com.syh.mall.service.ILikesService;
import com.syh.mall.utils.Result;
import com.syh.mall.vo.GoodsVO;
import com.syh.mall.vo.LikesVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @since 2022-02-03
 */
@RestController
@RequestMapping("/api/likes")
public class LikesController {

    @Autowired
    ILikesService likesService;

    @PostMapping("/addLike")
    @ApiOperation("添加/增加购物车商品")
    public Result<Object> addLike(@RequestBody LikesDTO likesDTO) {
        likesService.addLike(likesDTO);
        return Result.ofSuccess();
    }

    @PostMapping("/reduceLike")
    @ApiOperation("减少/删除购物车商品")
    public Result<Object> reduceLike(@RequestBody LikesDTO likesDTO) {
        likesService.reduceLike(likesDTO);
        return Result.ofSuccess();
    }

    @GetMapping("/getCart")
    @ApiOperation("查询购物车商品")
    public Result<List<GoodsVO>> getCart(String openId) {
        return Result.ofSuccess(likesService.getCart(openId));
    }

    @GetMapping("/getFinished")
    @ApiOperation("查询已完成交易的商品")
    public Result<List<GoodsVO>> getFinished(String openId) {
        return Result.ofSuccess(likesService.getFinished(openId));
    }

    @PostMapping("/delDeal")
    @ApiOperation("删除此次交易")
    public Result<Object> delDeal(@RequestBody LikesDTO likesDTO) {
        likesService.delDeal(likesDTO);
        return Result.ofSuccess();
    }

    @GetMapping("/doDeal")
    @ApiOperation("查询已完成交易的商品")
    public Result<Object> doDeal(String openId) {
        likesService.doDeal(openId);
        return Result.ofSuccess();
    }
}

