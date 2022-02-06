package com.syh.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.syh.mall.dto.LikesDTO;
import com.syh.mall.pojo.Likes;
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
public interface ILikesService extends IService<Likes> {

    void addLike(LikesDTO likesDTO);

    List<GoodsVO> getCart(String openId);

    void reduceLike(LikesDTO likesDTO);

    List<GoodsVO> getFinished(String openId);

    void delDeal(LikesDTO likesDTO);

    void doDeal(String openId);
}
