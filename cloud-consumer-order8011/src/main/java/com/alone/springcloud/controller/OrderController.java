package com.alone.springcloud.controller;

import com.alone.api.CommonResult;
import com.alone.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author alone
 * @date 2020/6/28
 * @desciption OrderController
 */
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult getPaymentById(@PathVariable("id") String id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/${id}", CommonResult.class);
    }

    @GetMapping("/serial/{serial}")
    public CommonResult getPaymentBySerial(@PathVariable("serial") String serial) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/serial/" + serial, CommonResult.class);
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/serial/${serial}", CommonResult.class);
    }

}
