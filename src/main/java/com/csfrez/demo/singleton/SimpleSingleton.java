package com.csfrez.demo.singleton;

/**
 * @author yangzhi
 * @date 2022/5/11
 * @email yangzhi@ddjf.com.cn
 */
public class SimpleSingleton {
    //持有自己类的引用
    private static final SimpleSingleton INSTANCE = new SimpleSingleton();

    //私有的构造方法
    private SimpleSingleton() {
    }
    //对外提供获取实例的静态方法
    public static SimpleSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(SimpleSingleton.getInstance().hashCode());
        System.out.println(SimpleSingleton.getInstance().hashCode());
    }
}