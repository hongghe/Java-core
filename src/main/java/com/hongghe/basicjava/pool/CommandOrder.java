package com.hongghe.basicjava.pool;

import com.netflix.hystrix.*;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author hongghe 2018/8/25
 */
@Slf4j
public class CommandOrder extends HystrixCommand<String> {

    private String orderName;

    public CommandOrder(String orderName) {
        super(Setter.withGroupKey(
                //服务分组
                HystrixCommandGroupKey.Factory.asKey("OrderGroup"))
                //线程分组
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("OrderPool"))
                //线程池配置
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)
                        .withKeepAliveTimeMinutes(5)
                        .withMaxQueueSize(10)
                        .withQueueSizeRejectionThreshold(10000))

                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
        );
        this.orderName = orderName;
    }


    @Override
    public String run() throws Exception {
        log.info("orderName=[{}]", orderName);
        TimeUnit.MILLISECONDS.sleep(100);
        return "OrderName=" + orderName;
    }


}