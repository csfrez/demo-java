package com.csfrez.demo.code;

public class SwitchDemo {

    public static void main(String[] args) {
        char c = 'A';
        int num = 10;
        switch (c){
            case 'B':
                num ++ ;
            case 'A':
                num ++ ;
            case 'Y':
                num ++ ;
                break;
            default:
                num -- ;
        }
        System.out.println(num);

    }
}
