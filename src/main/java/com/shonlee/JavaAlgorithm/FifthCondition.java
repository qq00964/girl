package com.shonlee.JavaAlgorithm;

import java.util.Scanner;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 * 1.程序分析：(a>b)?a:b这是条件运算符的基本例子。
 */
public class FifthCondition {
    //public static final int S1 = 90;
    //public static final int S2 = 60;
    static int grade;

    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        int s = str.nextInt();
        FifthCondition fc = new FifthCondition();
        grade = fc.compare(s);
        if (grade == 1) {
            System.out.print('A');
        } else if (grade == 2) {
            System.out.print('B');
        } else {
            System.out.println('C');
        }
    }

    public int compare(int s) {
        return s > 90 ? 1
                : s > 60 ? 2
                : 3;
    }
}
