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
 * <p>
 * 输入：[2,7,1,3,5]
 * <p>
 * 输出：12
 * <p>
 * 解释：抓取 2 号物品 (金额 = 7), 抓取 5 号物品 (金额 = 5)。
 * <p>
 * 抓取到的最高金额 = 7 + 5 = 12 。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入为路线上的物品价值, 输入为一个数组，使用空格隔开
 * <p>
 * 输出描述
 * 最终能获取的最大价值
 * <p>
 * <p>
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
        System.out.println(helper(nums));
    }

    public static int helper(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;

        //第一次抓的
        int max1 = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            max1 = Math.max(max1, nums[i]);
            index = i;
        }

        //冷却时间恰好飞过两个物品（即飞机冷却时间内无法抓取物品）
        if (index <= nums.length && index + 1 <= nums.length) return max1;

        int max2 = 0;
        for (int i = index; i <= nums.length; i += 2) {
            max2 = Math.max(max2, nums[i]);
        }
        max = max1 + max2;
        return max;
    }
}
