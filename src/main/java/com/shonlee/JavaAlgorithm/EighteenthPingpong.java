package com.shonlee.JavaAlgorithm;

/**
 * Created by ShonLee on 2017/6/13.
 * 题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。
 * 已抽签决定比赛名单。有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
 * <p>
 * <p>
 * 这个程序写得很不好，是知道结果后拼凑起来的，还不如直接写输出语句加上结果来的好。
 */
public class EighteenthPingpong {
    static char[] m = {'a', 'b', 'c'};
    static char[] n = {'x', 'y', 'z'};

    public static void main(String[] args) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if (m[i] == 'a' && n[j] == 'x') {
                    continue;
                } else if (m[i] == 'a' && n[j] == 'y') {
                    continue;
                } else if ((m[i] == 'c' && n[j] == 'x')
                        || (m[i] == 'c' && n[j] == 'z')) {
                    continue;
                } else if ((m[i] == 'b' && n[j] == 'z')
                        || (m[i] == 'b' && n[j] == 'y')) {
                    continue;
                } else
                    System.out.println(m[i] + " vs " + n[j]);
            }
        }
    }
}
