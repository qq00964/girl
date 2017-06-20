package com.shonlee.JavaAlgorithm;

import java.util.Scanner;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：给一个不多于5位的正整数，
 * 要求：一、求它是几位数，二、逆序打印出各位数字。
 * 说明： 这个算法实现虽然实现了这个功能，但不健壮，当输入字符是，会出现异常。
 */
public class Twenty_fourthNumber {
    public static void main(String[] args) {
        Twenty_fourthNumber tn = new Twenty_fourthNumber();
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        String s1 = Long.toString(a);
        char[] ch = s1.toCharArray();
        System.out.println(a + "是" + ch.length + "位数");
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }
    }
}
