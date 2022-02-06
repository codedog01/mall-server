package com.syh.mall.service.impl;

import com.alibaba.nacos.common.utils.JacksonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syh.mall.dto.GoodsDTO;
import com.syh.mall.mapper.GoodsImgMapper;
import com.syh.mall.mapper.GoodsMapper;
import com.syh.mall.mapper.GoodsTypeMapper;
import com.syh.mall.mapper.UserMapper;
import com.syh.mall.pojo.Goods;
import com.syh.mall.pojo.GoodsImg;
import com.syh.mall.pojo.User;
import com.syh.mall.service.IGoodsService;
import com.syh.mall.utils.AliOSSUtils;
import com.syh.mall.vo.CommodityVO;
import com.syh.mall.vo.GoodsVO;
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
    GoodsTypeMapper goodsTypeMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    AliOSSUtils aliOSSUtils;

    @Override
    public List<CommodityVO> selectAll() {
        List<CommodityVO> collect1 = goodsTypeMapper.selectList(new QueryWrapper<>()).stream().map(type -> {
            CommodityVO commodityVO = new CommodityVO();
            CommodityVO.Label label = new CommodityVO.Label();

            label.setName(type.getName());
            label.setIdx(type.getId());

            QueryWrapper<Goods> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("type", type.getName());
            List<CommodityVO.Goods> goodsList = goodsMapper.selectList(queryWrapper1).stream().map(item -> {
                CommodityVO.Goods goods = new CommodityVO.Goods();
                BeanUtils.copyProperties(item, goods);
                QueryWrapper<GoodsImg> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("goods_id", item.getId());
                List<String> collect = goodsImgMapper.selectList(queryWrapper).stream().map(GoodsImg::getImgUrl).collect(Collectors.toList());
                goods.setThumb(collect);
                return goods;
            }).collect(Collectors.toList());

            commodityVO.setLabel(label);
            commodityVO.setGoods(goodsList);
            return commodityVO;
        }).collect(Collectors.toList());
        System.out.println(JacksonUtils.toJson(collect1));
        return collect1;
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
            String url = aliOSSUtils.uploadDynamicImg(img.getImgBase64());
            goodsImg.setImgUrl(url);
            goodsImgMapper.insert(goodsImg);
        });

    }

    @Override
    public GoodsVO selectOne(String goodsId) {
        Goods goods = goodsMapper.selectById(goodsId);
        QueryWrapper<GoodsImg> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id", goods.getId());
        List<String> collect = goodsImgMapper.selectList(queryWrapper).stream().map(GoodsImg::getImgUrl).collect(Collectors.toList());
        GoodsVO goodsVO = new GoodsVO();
        BeanUtils.copyProperties(goods, goodsVO);
        goodsVO.setImages(collect);

        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("open_id", goods.getOpenId());
        User user = userMapper.selectOne(query);
        goodsVO.setAvatar(user.getAvatar());
        goodsVO.setNickName(user.getNickName());
        return goodsVO;
    }
}
