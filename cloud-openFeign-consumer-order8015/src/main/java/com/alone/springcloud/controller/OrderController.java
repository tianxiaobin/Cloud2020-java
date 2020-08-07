package com.alone.springcloud.controller;

import com.alone.api.CommonResult;
import com.alone.entity.Payment;
import com.alone.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alone
 * @date 2020/6/28
 * @desciption OrderController
 */
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public CommonResult create(Payment payment) {
        return orderService.create(payment);
    }

    @GetMapping("/{id}")
    public CommonResult getPaymentById(@PathVariable("id") String id) {
        return orderService.getPaymentById(id);
    }

    @GetMapping("/serial/{serial}")
    public CommonResult getPaymentBySerial(@PathVariable("serial") String serial) {
        return orderService.getPaymentBySerial(serial);
    }

    @GetMapping("error")
    @HystrixCommand(fallbackMethod = "error_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000") // 超时直接服务降级
    })
    public CommonResult error() {
        return orderService.error();
    }

    public String error_TimeOutHandler() {
        return Thread.currentThread().getName() + " 系统繁忙 , 请稍后再试  ==> id: " + "\t" + "( Ĭ ^ Ĭ )";
    }


}
