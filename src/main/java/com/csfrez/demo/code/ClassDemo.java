package com.csfrez.demo.code;

class ClassA {

    static {
        System.out.println("staticA");
    }

    public ClassA(){
        System.out.println("ClassA()");
    }
}

class ClassB extends ClassA{

    static {
        System.out.println("staticB");
    }

    public ClassB(){
        System.out.println("ClassB()");
    }
}


public class ClassDemo {

    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB = new ClassB();
    }
}
