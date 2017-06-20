package com.shonlee.JavaAlgorithm;

import java.util.Scanner;

/**
 * Created by ShonLee on 2017/6/13.
 * 按程序分析，好像只是求主对角线的和
 * 题目：求一个3*3矩阵对角线元素之和
 * 1.程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出
 */
public class Twenty_ninthCrossSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] a = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = s.nextInt();
            }
        }

        System.out.println("输入的3 * 3 矩阵是:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    sum += a[i][j];
                }
            }
        }
        System.out.println("对角线和是 " + sum);
    }
}
