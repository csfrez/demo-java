package com.csfrez.demo.sync;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(2); //两个执行完线程
        for(int i=0; i<2; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "， 子线程结束。");
                countDownLatch.countDown(); //执行线程减一
            }).start();
        }
        countDownLatch.await(); //等待全部线程结束
        System.out.println(Thread.currentThread().getName() + "， 主线程结束。");
    }
}
