package com.uin.level2.leetcode_1475;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1475. 商品折扣后的最终价格
 * 给你一个数组prices，其中prices[i]是商店里第i件商品的价格。
 * <p>
 * 商店里正在进行促销活动，如果你要买第i件商品，那么你可以得到与 prices[j] 相等的折扣，其中j是满足j > i且prices[j] <= prices[i]的最小下标，如果没有满足条件的j，你将没有任何折扣。
 * <p>
 * 请你返回一个数组，数组中第i个元素是折扣后你购买商品 i最终需要支付的价格。
 * <p>
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {8, 4, 6, 2, 3};
        helper(nums);
    }

    /**
     * 遍历
     *
     * @param prices
     * @return int[]
     * @author wanglufei
     * @date 2022/9/1 8:38 PM
     */
    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int discount = 0;
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            res[i] = prices[i] - discount;
        }
        return res;
    }

    /**
     * 单调栈
     *
     * @param prices
     * @return int[]
     * @author wanglufei
     * @date 2022/9/1 8:39 PM
     */
    public static int[] helper(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }
}
