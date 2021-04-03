package com.csfrez.demo.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2); //两个等待线程
        for(int i=0; i<3; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "， 线程等待开始。");
                try {
                    cyclicBarrier.await(); //等待足够的线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "， 线程等待结束。");
            }).start();
        }
    }

    public static void test2(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2); //两个等待线程
        for(int i=0; i<3; i++){
            int x = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "， 线程等待开始。");
                try {
                    if(x==1){
                        cyclicBarrier.reset(); //重置处理
                    } else {
                        cyclicBarrier.await(); //等待足够的线程
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "， 线程等待结束。");
            }).start();
        }
    }
}
