package com.syh.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syh.mall.dto.AddressDTO;
import com.syh.mall.mapper.AddressMapper;
import com.syh.mall.pojo.Address;
import com.syh.mall.service.IAddressService;
import com.syh.mall.vo.AddressVO;
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
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public void addAddress(AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        doSomething(addressDTO);
        addressMapper.insert(address);
    }

    @Override
    public void updateAddress(AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        doSomething(addressDTO);
        addressMapper.updateById(address);
    }

    @Override
    public void delAddress(Long addressId) {
        addressMapper.deleteById(addressId);
    }

    @Override
    public List<AddressVO> selectAllAddr(String openId) {
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq("open_id", openId);
        return addressMapper.selectList(addressQueryWrapper).stream().map(item -> {
            AddressVO addressVO = new AddressVO();
            BeanUtils.copyProperties(item, addressVO);
            return addressVO;
        }).collect(Collectors.toList());
    }

    @Override
    public AddressVO selectOneAddr(Long addressId) {
        Address address = addressMapper.selectById(addressId);
        AddressVO addressVO = new AddressVO();
        BeanUtils.copyProperties(address, addressVO);
        return addressVO;
    }

    private void doSomething(AddressDTO addressDTO) {
        if (addressDTO.getIsDefault()) {
            Address addr = new Address();
            addr.setIsDefault(false);
            QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
            addressQueryWrapper.eq("open_id", addressDTO.getOpenId());
            addressMapper.update(addr, addressQueryWrapper);
        }
    }
}
