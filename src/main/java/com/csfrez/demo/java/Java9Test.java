package com.csfrez.demo.java;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Java9Test {

    //java9特性五：钻石操作符的升级
    public void test2(){
        //钻石操作符与匿名内部类在java8中不能共存，在java9可以。
        Comparable<Object> comparable = new Comparable<>() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

        // JDK7中的新特性：类型推断
        ArrayList<String> arrayList = new ArrayList<>();
    }

    //java9特性六：try操作的升级
    public void test3(){
        //java8之前的资源关闭操作
        /*InputStreamReader reader = null;
        try {
            reader= new InputStreamReader(System.in);
            char[] buf = new char[20];
            int len ;
            if((len = reader.read(buf)) != -1){
                String str = new String(buf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (reader != null){
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        //java8中资源关闭操作:Java 8中，可以实现资源的自动关闭
        //要求自动关闭的资源的初始化必须放在try的一对小括号中
        /*try(InputStreamReader reader= new InputStreamReader(System.in)){
            char[] buf = new char[20];
            int len ;
            if((len = reader.read(buf)) != -1){
                String str = new String(buf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //java9中资源关闭操作: 需要自动关闭的资源的实例化可以放在try的一对小括号外
        //此时的资源属性是常量，声明为final的，不可修改
        InputStreamReader reader= new InputStreamReader(System.in);
        try(reader){
            char[] buf = new char[20];
            int len ;
            if((len = reader.read(buf)) != -1){
                String str = new String(buf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
