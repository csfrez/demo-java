package com.csfrez.demo.singleton;

/**
 * @author yangzhi
 * @date 2022/5/11
 * @email yangzhi@ddjf.com.cn
 */
public class SimpleSingleton1 {

    private volatile static SimpleSingleton1 INSTANCE;

    private SimpleSingleton1() {
    }

    public static SimpleSingleton1 getInstance() {
        if (INSTANCE == null) {
            synchronized (SimpleSingleton1.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SimpleSingleton1();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(SimpleSingleton1.getInstance().hashCode());
        System.out.println(SimpleSingleton1.getInstance().hashCode());
    }
}