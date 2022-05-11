package com.csfrez.demo.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yangzhi
 * @date 2022/5/11
 * @email yangzhi@ddjf.com.cn
 */
public class ThreadPoolConfig {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                8, //corePoolSize线程池中核心线程数
                10, //maximumPoolSize 线程池中最大线程数
                60, //线程池中线程的最大空闲时间，超过这个时间空闲线程将被回收
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue(500), //队列
                new ThreadPoolExecutor.CallerRunsPolicy()); //拒绝策略
    }
}
