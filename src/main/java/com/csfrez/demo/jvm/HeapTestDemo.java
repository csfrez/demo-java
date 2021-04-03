package com.csfrez.demo.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapTestDemo {

    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        List<HeapTestDemo> heapTestList = new ArrayList<>();

        while (true){
            heapTestList.add(new HeapTestDemo());
            Thread.sleep(10);
        }
    }
}
