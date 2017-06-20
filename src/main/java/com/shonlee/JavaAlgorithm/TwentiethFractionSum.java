package com.shonlee.JavaAlgorithm;

import java.text.DecimalFormat;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 * 1.程序分析：请抓住分子与分母的变化规律。
 */
public class TwentiethFractionSum {
    public static void main(String[] args) {
        int x = 2, y = 1, t;
        double sum = 0;

        DecimalFormat df = new DecimalFormat("#0.0000");

        for (int i = 1; i <= 20; i++) {
            sum += (double) x / y;
            t = y;
            y = x;
            x = y + t;
            System.out.println("第 " + i + " 次相加，和是 " + df.format(sum));
        }
    }
}