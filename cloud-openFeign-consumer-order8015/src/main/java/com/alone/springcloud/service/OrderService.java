package com.alone.springcloud.service;

import com.alone.api.CommonResult;
import com.alone.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author alone
 * @date 2020/7/29
 * @desciption OrderService
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderService {

    @PostMapping(value = "/create")
    public CommonResult create(Payment payment);

    @GetMapping(value = "/{id}")
    public CommonResult getPaymentById(String id);

    @GetMapping(value = "serial/{serial}")
    public CommonResult getPaymentBySerial(String serial);

    @GetMapping(value = "error")
    public CommonResult error();
}
