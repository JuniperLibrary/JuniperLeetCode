package com.uin.redbook.a2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 法术
 * <p>
 * 小明是一名魔法师，他会n种法术，其中第i种法术的威力为ai，他经常通过双手各自释放一种法术来提升威力，
 * 能得到的威力值为双手各自释放的法术的威力的乘积，但是他还不够强大，双手释放的两种法术必须是不同的，
 * 即不能双手释放同一种法术。这天他接到了一个任务，需要释放威力值至少为K才能完成，他想请你帮他算一算，在两只手都释放法术的情况下，
 * 共有多少方案能达到威力值K。
 * 每种方案可记作（u，v），u≠v，其威力值为au * av，（u，v）和（v，u）会被视为不同的方案。
 * <p>
 * 第一行两个正整数n和K，表示法术数量和威力值需求。
 * 第二行为n个正整数a1, a2,...... an，其中ai表示第i个法术的威力为ai。
 * <p>
 * 输出威力值至少为K的方案数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(helper(nums, k));
    }

    public static int helper(int[] nums, int k) {
        int max = k + 1;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    dp[i] = Math.max(dp[i], nums[i] * nums[j]);
                }
            }
        }

        return dp[k] > k ? -1 : dp[k];
    }
}
