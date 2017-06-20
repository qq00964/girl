package com.shonlee.JavaAlgorithm;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：判断101-200之间有多少个素数，并输出所有素数。
 * 程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，
 * 则表明此数不是素数，反之是素数。
 */
public class SecondPrimeNumber {
    public static int count = 0;

    public static void main(String[] args) {
        for (int i = 101; i < 200; i++) {
            boolean b = true;//默认此数就素数
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    b = false; //此数不是素数
                    break;
                }
            }
            if (b) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\n素数的个数：" + count);
    }
}
