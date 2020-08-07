package com.alone.springcloud.service.impl;

import com.alone.entity.Payment;
import com.alone.springcloud.dao.PaymentMapper;
import com.alone.springcloud.service.PaymentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 * @author alone
 * @date 2020/6/28
 * @desciption PaymentServiceImpl
 */
@Service
@Slf4j
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int insert(Payment payment) {
        payment.preInsert();
        return baseMapper.insert(payment);
    }

    @Override
    public Payment getPaymentById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Payment getPaymentBySerial(String serial) {
        QueryWrapper<Payment> wrapper = new QueryWrapper<Payment>();
        wrapper.eq("serial", serial);
        return baseMapper.selectOne(wrapper);
    }
}
