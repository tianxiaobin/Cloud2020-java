package com.alone.springcloud.service.impl;

import com.alone.entity.Payment;
import com.alone.springcloud.dao.PaymentMapper;
import com.alone.springcloud.service.PaymentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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

    @Override
    @HystrixCommand(fallbackMethod = "error_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String error() {
        int timeOut = 5000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
        }
        return Thread.currentThread().getName() + "耗时" + timeOut;
    }

    public String error_TimeOutHandler() {
        return Thread.currentThread().getName() + " 系统繁忙系统报错,请稍后再试id: " + "\t" + "( Ĭ ^ Ĭ )";
    }
}
