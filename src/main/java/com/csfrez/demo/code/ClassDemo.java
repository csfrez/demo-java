package com.csfrez.demo.code;

import java.util.Date;

class ClassA {

    static {
        System.out.println("staticA");
    }

    public ClassA(){
        System.out.println("ClassA()");
    }

    private void print(){
        System.out.println("printA()");
    }
}

class ClassB extends ClassA{

    static {
        System.out.println("staticB");
    }

    public ClassB(){
        System.out.println("ClassB()");
    }

    public void print(){
        System.out.println("printB()");
    }
}


public class ClassDemo {

    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB = new ClassB();
        classB.print();
        System.out.println("hello \\d world");
        System.out.println(Math.round(-15.61));

        int num = 50;
        num = num++ * 2;
        System.out.println(num);
        Date date = new Date();
        System.out.println(date.getMonth());
    }
}
