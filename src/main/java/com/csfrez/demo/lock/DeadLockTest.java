package com.csfrez.demo.lock;

/**
 * @author yangzhi
 * @date 2022/5/10
 * @email yangzhi@ddjf.com.cn
 */
public class DeadLockTest {

    public static String OBJECT_1 = "OBJECT_1";
    public static String OBJECT_2 = "OBJECT_2";

    public static void main(String[] args) {
        LockA lockA = new LockA();
        new Thread(lockA).start();

        LockB lockB = new LockB();
        new Thread(lockB).start();
    }

}

class LockA implements Runnable {

    @Override
    public void run() {
        synchronized (DeadLockTest.OBJECT_1) {
            try {
                Thread.sleep(500);

                synchronized (DeadLockTest.OBJECT_2) {
                    System.out.println("LockA");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class LockB implements Runnable {

    @Override
    public void run() {
        synchronized (DeadLockTest.OBJECT_2) {
            try {
                Thread.sleep(500);

                synchronized (DeadLockTest.OBJECT_1) {
                    System.out.println("LockB");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}