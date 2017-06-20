package com.shonlee.JavaAlgorithm;

import java.util.Scanner;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
 */
public class Twenty_fifthPalindrom {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个正整数：");
        long a = s.nextLong();
        String ss = Long.toString(a);
        char[] ch = ss.toCharArray();
        boolean is = true;
        int j = ch.length;
        for (int i = 0; i < j / 2; i++) {
            if (ch[i] != ch[j - i - 1]) {
                is = false;
            }
        }
        if (is == true) {
            System.out.println("这是一个回文数");
        } else {
            System.out.println("这不是一个回文数");
        }
    }
}
