package com.uin.level2.leetcode_202;

import java.util.HashSet;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(addInt(19));
    }

    /**
     * 计算数字的每个位数的和
     * 可以看看Leetcode 258 有相似之处
     *
     * @param n
     * @return int
     * @author wanglufei
     * @date 2022/8/26 1:37 PM
     */
    public static int addInt(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {
            n = addInt(n);
            if (!set.add(n)) return false;
        }
        return true;
    }
}
