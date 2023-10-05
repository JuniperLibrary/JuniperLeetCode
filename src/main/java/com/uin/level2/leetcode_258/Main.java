package com.uin.level2.leetcode_258;

/**
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于2 是一位数，所以返回 2。
 * ————————————————-
 * 输入: num = 0
 * 输出: 0
 */
public class Main {
    public int addDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        if (sum >= 10) {
            return addDigits(sum);
        } else {
            return sum;
        }
    }

    public int add(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }
}
