package com.alone.springcloud.service;

import com.alone.entity.Payment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author alone
 * @date 2020/6/28
 * @desciption PaymentController
 */
public interface PaymentService extends IService<Payment> {
    int insert(Payment payment);

    Payment getPaymentById(String id);

    Payment getPaymentBySerial(String serial);
}
