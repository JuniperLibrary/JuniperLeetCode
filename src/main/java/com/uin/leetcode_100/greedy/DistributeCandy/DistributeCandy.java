package com.uin.leetcode_100.greedy.DistributeCandy;
/**
 * leetcode 575 分糖果
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 * 最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 */
public class DistributeCandy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String[] split = scanner.nextLine().split(" ");
        int[] candies = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        int solution = solution(candies);
        System.out.println(solution);
    }

    public static int solution(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int c : candies) {
            set.add(c);
        }
        //return Math.min(set.size(), candies.length >> 1);
        /**
         * 左移一位相当于 * 2
         * 右移一位相当于 / 2
         */
        return Math.min(set.size(), candies.length / 2);
    }
}
