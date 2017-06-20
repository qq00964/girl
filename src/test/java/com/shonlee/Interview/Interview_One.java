package com.shonlee.Interview;

/**
 * Created by ShonLee on 2017/6/14.
 */
public class Interview_One {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "ab" + "c";
        System.out.println("a==b:" + a == b);
        System.out.println("a==c:" + a == c);
        System.out.println("a==d:" + a == d);
        System.out.println("b==c:" + b == c);
        System.out.println("b==d:" + b == d);
        System.out.println("c==d:" + c == d);
        System.out.println("a所占的字节数为："+a.getBytes().toString());
    }
}
