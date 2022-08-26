package com.uin.level1.leetcode_121;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Main {
    /**
     * 可以看做一种动态规划，只不过对空间复杂度进行了优化
     *
     * @param prices
     * @return int
     * @author wanglufei
     * @date 2022/8/16 10:08 AM
     */
    public int maxProfit(int[] prices) {
        /**
         * 最小的价格
         */
        int minPrice = Integer.MAX_VALUE;
        /**
         * 最大的利润
         */
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            //遍历数组找到最小的价格
            if (prices[i] < minPrice) minPrice = prices[i];
            //遍历数组更新最大的利润
            if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }

    /**
     * dp
     *
     * @param prices
     * @return int
     * @author wanglufei
     * @date 2022/8/16 10:08 AM
     */
    public int dp(int[] prices) {
        int maxProfit = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i] = dp[i - 1] < prices[i] ? dp[i - 1] : prices[i];
            maxProfit = prices[i] - dp[i] > maxProfit ? prices[i] - dp[i] : maxProfit;
        }
        return maxProfit;
    }
}
