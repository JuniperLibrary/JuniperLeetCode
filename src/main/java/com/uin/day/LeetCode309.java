package main.java.com.uin.day;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LeetCode309 {

  /**
   * 309. 买卖股票的最佳时机含冷冻期
   * <p>
   * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
   * <p>
   * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
   * <p>
   * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
   * <p>
   * 示例 1:
   * <p>
   * 输入: prices = [1,2,3,0,2] 输出: 3 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 示例 2:
   * <p>
   * 输入: prices = [1] 输出: 0
   *
   * @param prices
   * @return
   */

  public static int maxProfit(int[] prices) {
    /**
     因为当天卖出股票实际也是不持有的状态 那么第i天如果不持有
     */
    int days = prices.length;
    if (days <= 1) {
      return 0;
    }
    int[][] dp = new int[days][3];
    // 初始化阶段 本来就不持有 啥也没干
    dp[0][0] = 0;
    // 买入 第 0 天买入
    dp[0][1] = -1 * prices[0];
    // 可以理解成第 0 天 买入又卖出
    dp[0][2] = 0;

    for (int i = 1; i < days; i++) {
      // 从第1天
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
      dp[i][2] = dp[i - 1][1] + prices[i];
    }
    return Math.max(dp[days - 1][0], dp[days - 1][2]);
  }

  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 0, 2};
    log.info("maxProfit:{}", maxProfit(prices));
  }
}
