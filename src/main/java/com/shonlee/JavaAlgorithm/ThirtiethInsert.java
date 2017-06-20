package com.shonlee.JavaAlgorithm;

import java.util.Scanner;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
 * 1. 程序分析：首先判断此数是否大于最后一个数，
 * 然后再考虑插入中间的数的情况，插入后此元素之后的数，依次后移一个位置。
 */
public class ThirtiethInsert {
    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] b = new int[a.length + 1];
        int t1 = 0, t2 = 0;
        int i = 0;
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

   /*
   * 定义两个数组a，b，一个a的长度比另一个b大1， a看做是
   * 已经排好序的。
   * 接下来的过程是
   * 1: 如果num 比最后一个数大，把num赋值给数组b的最后一个数
   *    再按顺序把a 的每个元素赋给b
   * 2: 否则（num 不比a 的最后一个数大），
   *     如果a 的元素比num 小，则将这些元素按顺序赋给b
   *     将num 赋给比num大的b数组的元素，
   *     跳出第一个for循环。
   * 3: 定义一个循环控制变量，从num传给数组后num的下标值加一开始；
   *    直到b的结尾，将剩下的a 的值赋给b,赋值的过程是b[j] = a[i-1];
   *
   */

        if (num >= a[a.length - 1]) {
            b[b.length - 1] = num;
            for (i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
        } else {
            for (i = 0; i < a.length; i++) {
                if (num >= a[i]) {
                    b[i] = a[i];
                } else {
                    b[i] = num;
                    break;
                }
            }
            for (int j = i + 1; j < b.length; j++) {
                b[j] = a[j - 1];
            }
        }

        for (i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
