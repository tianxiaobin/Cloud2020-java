package com.alone.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author alone
 * @date 2020/7/7
 * @desciption PersonalIRule
 */
@Configuration
public class PersonalIRule {
    @Bean
    public IRule PersonalIRule(){
//        return new RoundRobinRule();//轮询(default)
//        return new RandomRule();// 随机
        return new RetryRule();// 重试（先按照轮询规则获取服务，如果获取服务失败则在指定时间内进行重试）
    }
}
