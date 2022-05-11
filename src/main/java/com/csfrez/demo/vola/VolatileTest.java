package com.csfrez.demo.vola;

/**
 * @author yangzhi
 * @date 2022/5/10
 * @email yangzhi@ddjf.com.cn
 */
public class VolatileTest {

    public volatile int count = 0;

    /*
    //volatile不能保证原子性
    public void add() {
        count++;
    }
    */
    public synchronized void add() {
        count++;
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for (int i = 0; i < 20; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.add();
                    }
                }

                ;
            }.start();
        }
        while (Thread.activeCount() > 2) {
            //保证前面的线程都执行完
            Thread.yield();
        }

        System.out.println(test.count);
    }

}
