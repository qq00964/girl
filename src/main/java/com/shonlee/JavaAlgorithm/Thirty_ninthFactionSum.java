package com.shonlee.JavaAlgorithm;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,
 * 当输入n为奇数时，调用函数1/1+1/3+...+1/n(利用指针函数)
 */
public class Thirty_ninthFactionSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        DecimalFormat df = new DecimalFormat("#0.00000");

        System.out.println(n + " **** result " + df.format(sum(n)));

    }

    public static double sum(int n) {
        double result = 0;
        if (n % 2 == 0) {
            for (int i = 2; i <= n; i += 2) {
                result += (double) 1 / n;
            }
        } else {
            for (int i = 1; i <= n; i += 2) {
                result += (double) 1 / i;
            }
        }
        return result;
    }
}
