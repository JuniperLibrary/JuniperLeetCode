package com.uin.glodon.a2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最多的人
 * 水平的列车上有n个座位，从左到右座位号为1,2,...,n。现在有m条规定，每条规定的形式如下：从座位l到座位r，不多于x个人乘坐。在满足所有规定的前提下，该列车最多能乘坐多少人？
 * <p>
 * 输入描述
 * 首先输入两个整数n,m（1≤,n,m≤10^5），表示有n个座位，有m个规定。 然后输入m行，每行三个整数l,r,x（1≤l≤r≤n,1≤x≤r-l+1），表示从座位l到座位r，不多于x个人乘坐。
 * <p>
 * 输出描述
 * 输出一个整数s，表示最多能乘坐s人。
 * <p>
 * 样例输入
 * 10 3
 * 1 4 2
 * 3 6 2
 * 10 10 1
 * 样例输出
 * 8
 * <p>
 * 提示
 * 用1表示有人乘坐，0表示空位，一种最优的方式为110 011 1111，可以乘坐8人。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();//n个座位
        int m = in.nextInt();//m个规定
        int[] ints = null;

        int ans = 0;
        while (m > 0 && in.hasNext()) {
            ints = new int[3];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = in.nextInt();
            }
            m--;

            int[] dp = new int[n+1];

            Arrays.fill(dp, 0);

            int l = ints[0];
            int r = ints[1];
            int x = ints[2];

            for (int i = 1; i <= dp.length; i++) {
                for (int j = dp.length; j >= 0; j--) {
                    if (i == l && r == j && i <= dp.length && j >= 0) {
                        while (i <= j && x > 0) {
                            dp[i] = dp[i] == 0 ? 1 : 1;
                            x--;
                            i++;
                            j--;
                        }
                    }
                }
            }

            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == 1) {
                    ans += ans;
                }
            }
        }
        System.out.println(ans);
    }
}
