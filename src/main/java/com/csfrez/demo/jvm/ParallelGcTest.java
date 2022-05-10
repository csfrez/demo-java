package com.csfrez.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhi
 * @date 2021/11/23
 * @email yangzhi@ddjf.com.cn
 */
public class ParallelGcTest {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        allocate();
    }

    private static void allocate(){
        // 强引用分配的对象, 为了触发FGC
        List<byte[]> holder = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            byte[] tmp = new byte[_1M];
            // 不要让FGC来的太快
            if (i%10==0) {
                holder.add(tmp);
            }
        }
    }
}
