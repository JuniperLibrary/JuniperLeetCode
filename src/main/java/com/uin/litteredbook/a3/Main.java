package com.uin.litteredbook.a3;

import java.util.Scanner;

/**
 * 薯队长写了n篇笔记，编号从1~n,每篇笔记都获得了不少点赞数。
 * 薯队长想从中选出一些笔记，作一个精选集合。挑选的时候有两个规则：
 * 1.不能出现连续编号的笔记。
 * 2.总点赞总数最多
 * 如果满足1，2条件有多种方案，挑选笔记总数最少的那种
 * ————————————————————————————————————————
 * 打家劫舍，dp，选与不选的最优问题
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }

        //总点赞数
        int[] dp = new int[n + 1];
        dp[1] = nums[0];

        // 挑选笔记
        int[] dp2 = new int[n + 1];
        dp2[1] = 1;

        for (int i = 2; i <= n; i++) {
            //选
            if (dp[i - 1] < dp[i - 2] + nums[i - 1]) {
                dp[i] = dp[i - 2] + nums[i - 1];
                dp2[i] = dp2[i - 2] + 1;
            } else {
                dp[i] = dp[i - 1];
                dp2[i] = dp2[i - 1];
            }
        }
        System.out.println(dp[n] + " " + dp2[n]);
    }
}
