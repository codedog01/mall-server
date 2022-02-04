package com.syh.mall.controller;


import com.syh.mall.dto.DynamicDTO;
import com.syh.mall.service.IDynamicService;
import com.syh.mall.utils.Result;
import com.syh.mall.vo.DynamicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/dynamic")
public class DynamicController {

    @Autowired
    IDynamicService dynamicService;

    @GetMapping("/selectAll")
    public Result<List<DynamicVO>> selectAll(DynamicDTO dynamicDTO) {
        return Result.ofSuccess(dynamicService.selectAll(dynamicDTO));
    }

    @PostMapping("/addDynamic")
    public void addDynamic(@RequestBody DynamicDTO dynamicDTO) {
        dynamicService.addDynamic(dynamicDTO);
    }

}

