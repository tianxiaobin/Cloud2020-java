package com.alone.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.alone.api.CommonResult;
import com.alone.entity.Payment;
import com.alone.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author alone
 * @date 2020/6/28
 * @desciption PaymentController
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 支付模拟
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("入参信息:{}", JSON.toJSONString(payment));
        CommonResult commonResult;
        int count = paymentService.insert(payment);
        if (count == 1) {
            commonResult = CommonResult.success(payment);
            log.info("insert success:{}", payment);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.info("insert failed:{}", payment);
        }
        return commonResult;
    }

    /**
     * 查询支付记录
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public CommonResult getPaymentById(@PathVariable("id") String id) {
        log.info("入参信息:{}", JSON.toJSONString(id));
        CommonResult commonResult;
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById != null) {
            commonResult = CommonResult.success(paymentById);
            log.info("select success:{}", paymentById);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.info("insert failed:{}", (Object) null);
        }
        return commonResult;
    }

    /**
     * 查询支付记录
     *
     * @param serial
     * @return
     */
    @GetMapping(value = "serial/{serial}")
    public CommonResult getPaymentBySerial(@PathVariable("serial") String serial) {
        log.info("入参信息:{}", JSON.toJSONString(serial));
        CommonResult commonResult;
        Payment paymentBySerial = paymentService.getPaymentBySerial(serial);
        if (paymentBySerial != null) {
            commonResult = CommonResult.success(paymentBySerial);
            log.info("select success:{}", paymentBySerial);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.info("insert failed:{}", (Object) null);
        }
        return commonResult;
    }

    /**
     * Hystrix超时测试
     *
     * @return
     */
    @GetMapping(value = "error")
    public CommonResult error() {
        CommonResult commonResult;
        String str = paymentService.error();
        if (!Objects.isNull(str)) {
            commonResult = CommonResult.success(str);
            log.info("select success:{}", str);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.info("insert failed:{}", (Object) null);
        }
        return commonResult;
    }

}
