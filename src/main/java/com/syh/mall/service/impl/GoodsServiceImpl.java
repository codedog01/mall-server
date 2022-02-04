package com.syh.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syh.mall.dto.GoodsDTO;
import com.syh.mall.mapper.GoodsImgMapper;
import com.syh.mall.mapper.GoodsMapper;
import com.syh.mall.pojo.Goods;
import com.syh.mall.pojo.GoodsImg;
import com.syh.mall.service.IGoodsService;
import com.syh.mall.utils.AliOSSUtils;
import com.syh.mall.vo.CommodityVO;
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
 * @author ${author}
 * @since 2022-02-03
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsImgMapper goodsImgMapper;

    @Autowired
    AliOSSUtils aliOSSUtils;

    @Override
    public List<CommodityVO> selectAll() {
        return goodsMapper.selectList(new QueryWrapper<>()).stream().map(item -> {
            CommodityVO commodityVO = new CommodityVO();
            CommodityVO.Goods goods = commodityVO.getGoods();
            CommodityVO.Label label = commodityVO.getLabel();

            QueryWrapper<GoodsImg> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("goods_id", item.getId());
            List<String> collect = goodsImgMapper.selectList(queryWrapper).stream().map(GoodsImg::getImgUrl).collect(Collectors.toList());
            goods.setThumb(collect);

            label.setName(item.getType());
            label.setIdx(item.getId());

            return commodityVO;
        }).collect(Collectors.toList());


    }

    @Override
    public void addGoods(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDTO, goods);
        goodsMapper.insert(goods);

        goodsDTO.getImgList().forEach(img -> {
            GoodsImg goodsImg = new GoodsImg();
            goodsImg.setGoodsId(goods.getId());
            /*把MinIO url存到数据库*/
            String url = aliOSSUtils.uploadDynamicImg(img);
            goodsImg.setImgUrl(url);
            goodsImgMapper.insert(goodsImg);
        });

    }
}
