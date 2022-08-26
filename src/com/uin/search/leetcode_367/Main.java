package com.uin.search.leetcode_367;

/**
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * 输入：num = 16
 * 输出：true
 * <p>
 * 输入：num = 14
 * 输出：false
 */
public class Main {
    /**
     * 迭代
     *
     * @param num
     * @return boolean
     * @author wanglufei
     * @date 2022/8/26 10:39 PM
     */
    public boolean isPerfectSquare(int num) {
        long x = 1, square = 1;
        while (square <= num) {
            if (square == num) {
                return true;
            }
            x++;
            square = x * x;
        }
        return false;
    }

    /**
     * 二分
     *
     * @param num
     * @return boolean
     * @author wanglufei
     * @date 2022/8/26 10:40 PM
     */
    public boolean helper(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
