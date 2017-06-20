package com.shonlee.JavaAlgorithm;

import java.util.Scanner;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：冒泡排序  输入三个整数x,y,z，请把这三个数由小到大输出。
 * 1.程序分析：我们想办法把最小的数放到x上，先将x与y进行比较，
 * 如果x> y则将x与y的值进行交换，然后再用x与z进行比较，
 * 如果x> z则将x与z的值进行交换，这样能使x最小。
 */
public class FifteenthNumberCompare {
    public static void main(String[] args) {
        FifteenthNumberCompare fnc = new FifteenthNumberCompare();
        int a, b, c;

        System.out.println("Input 3 numbers:");
        a = fnc.input();
        b = fnc.input();
        c = fnc.input();
//
//   fnc.compare(a, b);//方法调用不能通过改变形参的值来改变实参的值
//   fnc.compare(b, c);// 这种做法是错的
//   fnc.compare(a, c);
        //System.out.println("result:" + a +" " + b + " " + c);// 没有改变

        if(a > b) {
            int t = a;
            a = b;
            b = t;
        }

        if(a > c) {
            int t = a;
            a = c;
            c = t;
        }

        if(b > c) {
            int t = b;
            b = c;
            c = t;
        }
        System.out.println( a + " " + b + " " + c);
    }
    public int input() {
        int value = 0;
        Scanner s = new Scanner(System.in);
        value = s.nextInt();
        return value;
    }
    public void compare(int x, int y) {//此方法没用
        if(x > y) {
            int t = x;
            x = y;
            y = t;
        }
    }
}
