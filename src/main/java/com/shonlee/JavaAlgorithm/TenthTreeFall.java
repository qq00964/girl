package com.shonlee.JavaAlgorithm;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，
 * 求它在 第10次落地时，共经过多少米？第10次反弹多高？
 */
public class TenthTreeFall {
    static double height = 100;
    static double distance = 100;

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            distance = distance + height;
            height = height / 2;
        }

        System.out.println("路程：" + distance);
        System.out.println("高度：" + height / 2);
    }
}
