package com.syh.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syh.mall.dto.LikesDTO;
import com.syh.mall.mapper.AddressMapper;
import com.syh.mall.mapper.GoodsImgMapper;
import com.syh.mall.mapper.GoodsMapper;
import com.syh.mall.mapper.LikesMapper;
import com.syh.mall.pojo.Address;
import com.syh.mall.pojo.Goods;
import com.syh.mall.pojo.GoodsImg;
import com.syh.mall.pojo.Likes;
import com.syh.mall.service.ILikesService;
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
public class LikesServiceImpl extends ServiceImpl<LikesMapper, Likes> implements ILikesService {

    @Autowired
    LikesMapper likesMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsImgMapper goodsImgMapper;

    @Autowired
    AddressMapper addressMapper;

    @Override
    public void addLike(LikesDTO likesDTO) {
        QueryWrapper<Likes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id", likesDTO.getGoodsId()).eq("open_id", likesDTO.getOpenId()).eq("is_deal", false);
        Likes likes = likesMapper.selectOne(queryWrapper);
        if (null != likes) {
            likes.setNum(likes.getNum() + 1);
            likesMapper.updateById(likes);
        } else {
            likes = new Likes();
            BeanUtils.copyProperties(likesDTO, likes);
            likesMapper.insert(likes);
        }
    }

    @Override
    public List<GoodsVO> getCart(String openId) {
        QueryWrapper<Likes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId).eq("is_deal", false);
        return getGoodsVOS(queryWrapper);
    }

    @Override
    public void reduceLike(LikesDTO likesDTO) {
        QueryWrapper<Likes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id", likesDTO.getGoodsId()).eq("open_id", likesDTO.getOpenId()).eq("is_deal", false);
        Likes likes = likesMapper.selectOne(queryWrapper);
        if (likes.getNum() == 1) {
            likesMapper.deleteById(likes);
        } else {
            likes.setNum(likes.getNum() - 1);
            likesMapper.updateById(likes);
        }
    }

    @Override
    public List<GoodsVO> getFinished(String openId) {
        QueryWrapper<Likes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId).eq("is_deal", true);
        return getGoodsVOS(queryWrapper);
    }

    @Override
    public void delDeal(LikesDTO likesDTO) {
        QueryWrapper<Likes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", likesDTO.getOpenId()).eq("goods_id", likesDTO.getGoodsId());
        likesMapper.delete(queryWrapper);
    }

    @Override
    public Integer doDeal(String openId) {
        QueryWrapper<Likes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId);
        Likes likes = new Likes();
        likes.setIsDeal(true);
        return likesMapper.update(likes, queryWrapper);
    }

    @Override
    public Boolean hasDefaultAddr(String openId) {
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq("open_id", openId).eq("is_default", true);
        Address address = addressMapper.selectOne(addressQueryWrapper);
        return null != address;
    }

    private List<GoodsVO> getGoodsVOS(QueryWrapper<Likes> queryWrapper) {
        return likesMapper.selectList(queryWrapper).stream().map(item -> {
            GoodsVO goodsVO = new GoodsVO();
            Goods goods = goodsMapper.selectById(item.getGoodsId());
            BeanUtils.copyProperties(goods, goodsVO);
            goodsVO.setNum(item.getNum());
            QueryWrapper<GoodsImg> imgVOQueryWrapper = new QueryWrapper<>();
            imgVOQueryWrapper.eq("goods_id", item.getGoodsId());
            List<String> collect = goodsImgMapper.selectList(imgVOQueryWrapper).stream().map(GoodsImg::getImgUrl).collect(Collectors.toList());
            goodsVO.setImages(collect);
            return goodsVO;
        }).collect(Collectors.toList());
    }


}
