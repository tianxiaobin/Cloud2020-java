package com.alone.springcloud.dao;

import com.alone.entity.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author alone
 * @date 2020/6/28
 * @desciption PaymentServiceImpl
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
