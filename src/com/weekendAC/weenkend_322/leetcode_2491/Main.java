package com.weekendAC.weenkend_322.leetcode_2491;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 2491. 划分技能点相等的团队
 * 给你一个正整数数组 skill ，数组长度为 偶数 n ，其中 skill[i] 表示第 i 个玩家的技能点。将所有玩家分成 n / 2 个 2 人团队，使每一个团队的技能点之和 相等 。
 * <p>
 * 团队的 化学反应 等于团队中玩家的技能点 乘积 。
 * 返回所有团队的 化学反应 之和，如果无法使每个团队的技能点之和相等，则返回 -1 。
 * 示例 1：
 * <p>
 * 输入：skill = [3,2,5,1,3,4]
 * 输出：22
 * 解释：
 * 将玩家分成 3 个团队 (1, 5), (2, 4), (3, 3) ，每个团队的技能点之和都是 6 。
 * 所有团队的化学反应之和是 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22 。
 * 示例 2：
 * <p>
 * 输入：skill = [3,4]
 * 输出：12
 * 解释：
 * 两个玩家形成一个团队，技能点之和是 7 。
 * 团队的化学反应是 3 * 4 = 12 。
 * 示例 3：
 * <p>
 * 输入：skill = [1,1,2,3]
 * 输出：-1
 * 解释：
 * 无法将玩家分成每个团队技能点都相等的若干个 2 人团队。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= skill.length <= 105
 * skill.length 是偶数
 * 1 <= skill[i] <= 1000
 */
public class Main {
    public static void main(String[] args) {
        int[] skill = {3, 2, 5, 1, 3, 4};
        System.out.println(dividePlayers(skill));
    }

    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int sum = skill[0] + skill[n - 1];
        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            int x = skill[i], y = skill[n - 1 - i];
            if (x + y != sum) {
                return -1;
            }
            ans = ans + x * y;
        }
        return ans;
    }

    public static long helper(int[] skill) {
        HashMap<Integer, Integer> val2cnt = new HashMap<>();

        int sum = Arrays.stream(skill).sum();
        int n = skill.length;
        //团队技能点之和应为整数
        if (sum % (n / 2) != 0)
            return -1;

        //技能点计数
        for (int s : skill)
            val2cnt.merge(s, 1, Integer::sum);

        int target = sum / (n / 2);
        long ans = 0;
        for (int s : skill) {
            //已经被一个团队选中
            if (val2cnt.get(s) <= 0)
                continue;

            Integer t = val2cnt.get(target - s);
            //无法找到匹配的玩家
            if (t == null || t <= 0)
                return -1;

            //更新技能点计数
            val2cnt.merge(s, -1, Integer::sum);
            val2cnt.merge(target - s, -1, Integer::sum);

            //求取 化学反应 之和
            ans += (long) s * (target - s);
        }

        return ans;
    }
}
