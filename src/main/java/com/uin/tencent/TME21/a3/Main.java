package main.java.com.uin.tencent.TME21.a3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 腾讯音乐娱乐（TME）2021暑期实习生招聘技术类笔试--最小代价
 * 给你一个数组a,让第i个数加一的代价是b(i),你可以求出让数组a,每个数各不相同的最小代价吗?
 * <p>
 * 第一行一个整数n,表示数组长度
 * 第二行个整数a_i,表示数组
 * 第三行个整数b_i,表示第个增加1的代价
 * <p>
 * 3
 * 1 1 2
 * 4 5 3
 * <p>
 * 7
 * <p>
 * 先把第1个数字1加1，此时代价为4，a数组为2 1 2。然后再把第三个数字2加1，此时代价为4+3=7，a数组为2 1 3。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] tmp = new int[n][2];

        for (int i = 0; i < n; i++) {
            tmp[i][0] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            tmp[i][1] = in.nextInt();
        }

        Arrays.sort(tmp, (o1, o2) -> {
            //代价
            if (o1 == o2) {
                return o1[1] - o2[1];
            }
            //数组
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        int cur = tmp[0][0];
        long all = 0;
        long ans = 0;

        for (int[] price : tmp) {
            if (!queue.isEmpty() && price[0] != cur) {
                while (!queue.isEmpty() && price[0] != cur++) {
                    all -= queue.poll();
                    ans += all;
                }
                cur = price[0];
            }
            queue.add(price[1]);
            all += price[1];
        }

        while (!queue.isEmpty()) {
            all = queue.poll();
            ans += all;
        }
        System.out.println(ans);
    }
}
