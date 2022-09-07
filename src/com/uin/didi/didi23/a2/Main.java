package com.uin.didi.didi23.a2;

import java.util.Scanner;

/**
 * 老张的美数课
 * 老张教授开了一堂美数课！
 * 老张认为每个非负整数x都有一个美丽值b(x)。
 * 一个非负整数的美丽值定义为这个数十进制下每个数位的异或和。
 * 即，对于123来说，美丽值为1^2^3=0，对于654815424美丽值为6^5^4^8^1^5^4^2^4=9 （在C/C++中^运算符表示异或）
 * 现在老张想考考同学，对于[L,R]这个闭区间内的所有整数，美丽值恰好为t的数有多少个。
 * <p>
 * 第一行一个正整数，表示有次询问。
 * 接下来有三行：
 * 第一行个非负整数 L1,L2,...,Li,...,LT(1≤i≤T)
 * 第二行个非负整数  R1,R2,...,Ri,...,RT(1≤i≤T)
 * 第三行个非负整数  t1,t2,...,ti,...,tT(1≤i≤T)
 * 每个询问是对于 [Li, Ri] (Li≤Ri)这个闭区间内的所有整数，美丽值恰好为的数有多少个。
 * <p>
 * 每个询问输出T个整数，每两个数之间用空格隔开，表示答案。
 * <p>
 * 2
 * 0 1
 * 0 10
 * 0 1
 * <p>
 * 1 2
 * <p>
 * 一共两次询问。
 * 第1次询问 [0, 0] 这个区间中美丽值为0的有多少个，0的美丽值为0，答案为1。
 * 第2次询问 [1, 10] 这个区间中美丽值为1的有多少个，1和10的美丽值为1，答案为2。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] L = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = in.nextInt();
        }

        int[] R = new int[n];
        for (int i = 0; i < n; i++) {
            R[i] = in.nextInt();
        }

        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
        }
    }

    public static int[] helper(int[] L, int[] R, int[] t) {
        int n = L.length;
        int[] ans = new int[n];

        for (int i = 0; i < ans.length; i++) {
            ans[i++] = solveBeautiful(L[i], R[i]);
        }
        return ans;
    }

    public static int solveBeautiful(int start, int end) {
        int bea = 0;
        int count = 0;

        for (int i = start; i <= end; i++) {
            bea = (start % 10) ^ start;
            if (bea == start) {
                count++;
            }
        }
        return count;
    }
}
