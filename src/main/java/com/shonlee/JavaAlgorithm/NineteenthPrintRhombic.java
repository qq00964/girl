package com.shonlee.JavaAlgorithm;

/**
 * Created by ShonLee on 2017/6/13.
 * 1.程序分析：先把图形分成两部分来看待，前四行一个规律，后三行一个规律，利用双重 for循环，
 * 第一层控制行，第二层控制列。
 * <p>
 * 上半部分循环变量的控制方法是
 * for(int i=0; i<(HEIGHT+1) / 2; i++) {
 * for(int j=1; j<WIDTH/2-i; j++) {
 * for(int k=1; k<(i+1)*2; k++) {
 * <p>
 * 下半部分循环变量的控制方法是
 * for(int i=1; i<=HEIGHT/2; i++) {
 * for(int j=1; j<=i; j++) {
 * for(int k=1; k<=WIDTH-2*i-1; k++) {
 */
public class NineteenthPrintRhombic {
    static final int HEIGHT = 7;
    static final int WIDTH = 8;
    public static void main(String[] args) {
        for(int i=0; i<(HEIGHT+1) / 2; i++) {
            for(int j=1; j<WIDTH/2-i; j++) {
                System.out.print(" ");
            }
            for(int k=1; k<(i+1)*2; k++) {
                System.out.print('*');
            }
            System.out.println();
        }

        for(int i=1; i<=HEIGHT/2; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(" ");
            }
            for(int k=1; k<=WIDTH-2*i-1; k++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
