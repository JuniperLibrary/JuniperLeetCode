package com.uin.feibu.leetcode_1196;

import java.util.Arrays;

/**
 * Leetcode 1196：最多可以买到的苹果数量
 * 楼下水果店正在促销，你打算买些苹果，weights[i] 表示第 i 个苹果的单位重量。
 * 你有一个购物袋，最多可以装 5000 单位重量的东西，算一算，最多可以往购物袋里装入多少苹果。
 * 输入：weights = [100,200,150,1000]
 * 输出：4
 * 解释：所有 4 个苹果都可以装进去，因为它们的重量之和为 1450。
 */
public class Main {
    private static int k = 5000;

    public static int maxNumberOfApples(int[] weights) {
        Arrays.sort(weights);
        int res = 0;
        for (int weight : weights) {
            k -= weight;
            if (k >= 0) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] weights = {100, 200, 150, 1000};
        System.out.println(maxNumberOfApples(weights));
    }
}
