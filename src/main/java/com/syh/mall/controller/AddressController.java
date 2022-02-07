package com.syh.mall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syh.mall.dto.AddressDTO;
import com.syh.mall.mapper.GoodsTypeMapper;
import com.syh.mall.service.IAddressService;
import com.syh.mall.utils.Result;
import com.syh.mall.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    IAddressService addressService;

    @PostMapping("/addAddress")
    public Result<Object> addAddress(@RequestBody AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return Result.ofSuccess();
    }

    @PostMapping("/updateAddress")
    public Result<Object> updateAddress(@RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return Result.ofSuccess();
    }

    @GetMapping("/delAddress")
    public Result<Object> delAddress(Long addressId) {
        addressService.delAddress(addressId);
        return Result.ofSuccess();
    }

    @GetMapping("/selectAllAddr")
    public Result<List<AddressVO>> selectAllAddr(String openId) {
        return Result.ofSuccess(addressService.selectAllAddr(openId));
    }

    @GetMapping("/selectOneAddr")
    public Result<AddressVO> selectOneAddr(Long addressId) {
        return Result.ofSuccess(addressService.selectOneAddr(addressId));
    }
}

