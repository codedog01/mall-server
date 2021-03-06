package com.syh.mall.service;

import com.syh.mall.dto.DynamicDTO;
import com.syh.mall.pojo.Dynamic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.syh.mall.vo.DynamicVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-02-03
 */
public interface IDynamicService extends IService<Dynamic> {

    void addDynamic(DynamicDTO dynamicDTO);

    List<DynamicVO> selectAll(DynamicDTO dynamicDTO);
}
