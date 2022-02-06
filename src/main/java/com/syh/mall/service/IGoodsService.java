package com.syh.mall.service;

import com.syh.mall.dto.GoodsDTO;
import com.syh.mall.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.syh.mall.vo.CommodityVO;
import com.syh.mall.vo.GoodsVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-02-03
 */
public interface IGoodsService extends IService<Goods> {

    List<CommodityVO> selectAll();

    void addGoods(GoodsDTO goodsDTO);

    GoodsVO selectOne(String goodsId);
}
