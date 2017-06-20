package com.shonlee.JavaAlgorithm;

import java.util.Scanner;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：请输入星期几的第一个字母来判断一下是星期几，
 * 如果第一个字母一样，则继续 判断第二个字母。
 * 1.程序分析：用情况语句比较好，如果第一个字母一样，
 * 则判断用情况语句或if语句判断第二个字母。
 * 此程序虽然实现了基本功能，但必须严格按照题目的要求输入，否则程序无法执行
 */
public class Twenty_sixthWeek {
    public static void main(String[] args) {
        Twenty_sixthWeek tw = new Twenty_sixthWeek();
        char ch = tw.getChar();
        switch (ch) {
            case 'M':
                System.out.println("Monday");
                break;
            case 'W':
                System.out.println("Wednesday");
                break;
            case 'F':
                System.out.println("Friday");
                break;
            case 'T': {
                System.out.println("please input the second letter!");
                char ch2 = tw.getChar();
                if (ch2 == 'U') {
                    System.out.println("Tuesday");
                } else if (ch2 == 'H') {
                    System.out.println("Thursday");
                }

            }
            ;
            break;
            case 'S': {
                System.out.println("please input the scecond letter!");
                char ch2 = tw.getChar();
                if (ch2 == 'U') {
                    System.out.println("Sunday");
                } else if (ch2 == 'A') {
                    System.out.println("Saturday");
                }

            }
            ;
            break;
        }
    }

    public char getChar() {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char ch = str.charAt(0);
        if (ch < 'A' || ch > 'Z') {
            System.out.println("Input error, please input a capital letter");
            getChar();
        }
        return ch;
    }
}
