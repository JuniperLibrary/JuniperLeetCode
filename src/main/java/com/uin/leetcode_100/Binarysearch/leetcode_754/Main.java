package main.java.com.uin.leetcode_100.Binarysearch.leetcode_754;

/**
 * LeetCode 754. 到达终点数字
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * <p>
 * 你可以做一些数量的移动 numMoves :
 * <p>
 * 每次你可以选择向左或向右移动。
 * 第 i次移动（从 i == 1开始，到i == numMoves ），在选择的方向上走 i步。
 * 给定整数target ，返回 到达目标所需的 最小移动次数(即最小 numMoves )。
 * <p>
 * 示例 1:
 * <p>
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * 示例 2:
 * <p>
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(reachNumber(2));
    }
    public static int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}
