package com.uin.leetcode_100.math.leetcode_1780;

/**
 * 1780.判断一个数字是否可以表示成三的幂的和
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 * 示例 2：
 * <p>
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 * 示例 3：
 * <p>
 * 输入：n = 21
 * 输出：false
 * 提示：
 * 1 <= n <= 107
 */
public class Main {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 > 1) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}
