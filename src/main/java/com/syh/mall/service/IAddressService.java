package com.syh.mall.service;

import com.syh.mall.dto.AddressDTO;
import com.syh.mall.pojo.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import com.syh.mall.vo.AddressVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-02-03
 */
public interface IAddressService extends IService<Address> {

    void addAddress(AddressDTO addressDTO);

    void updateAddress(AddressDTO addressDTO);

    void delAddress(Long addressId);

    List<AddressVO> selectAllAddr(String openId);

    AddressVO selectOneAddr(Long addressId);
}
