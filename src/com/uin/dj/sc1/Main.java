package com.uin.dj.sc1;
/**
 * 获取最大收益
 * 题目描述：
 * DJI 现有一款新型无人机，假设这架无人机做匀速直线飞行，飞行路途上有均匀存放价值不等的物品，
 * 飞机有个小爪子，可抓取途中物品, 当抓取到后，飞机抓取功能进入冷却阶段，冷却时间恰好飞过两个物品（即飞机冷却时间内无法抓取物品）
 * <p>
 * 给定一个代表飞行途中存放物品价值的非负整数数组，请计算出飞机沿途能抓取的物品的最大价值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,4,3,2]
 * <p>
 * 输出：6
 * <p>
 * 解释：抓取 2 号物品 (金额 = 4) ，然后抓取 4 号物品 (金额 = 2)。
 * <p>
 * 抓取到的最高金额 = 4 + 2 = 6 。
 * <p>
 * 示例 2：
 * 输入：[2,7,1,3,5]
 * 输出：12
 * 解释：抓取 2 号物品 (金额 = 7), 抓取 5 号物品 (金额 = 5)。
 * 抓取到的最高金额 = 7 + 5 = 12 。
 * 输入描述
 * 输入为路线上的物品价值, 输入为一个数组，使用空格隔开
 * <p>
 * 输出描述
 * 最终能获取的最大价值
 * 样例输入
 * 2 7 1 3 5
 * 样例输出
 * 12
 *
 * @author wanglufei
 * @date 2022/8/7 7:25 PM
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split("\\s+");
        int[] nums = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(nums));
    }


    public static int solution(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return 0;

        //状态容器
        int[] R = new int[n];
        int[] NR = new int[n];

        //初始化
        R[0] = nums[0];
        NR[0] = 0;

        for (int i = 1; i < n; i++) {
            R[i] = nums[i] + NR[i - 1];
            NR[i] = Math.max(NR[i - 1], R[i - 1]);
        }
        return Math.max(NR[n - 1], R[n - 1]);
    }

    public static int solution2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // 状态容器初始化
        int R = 0;
        int NR = 0;

        //状态转移方程
        for (int i = 0; i < nums.length; i++) {
            int max = Math.max(R, NR);
            R = nums[i] + NR;
            NR = max;
        }
        return Math.max(R, NR);
    }
}
