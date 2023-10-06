package com.uin.day;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LeetCode714 {

  /**
   * 714. 买卖股票的最佳时机含手续费
   * <p>
   * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
   * <p>
   * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
   * <p>
   * 返回获得利润的最大值。
   * <p>
   * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
   * <p>
   * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
   * <p>
   * 输出：8
   * <p>
   * 解释：能够达到的最大利润: 在此处买入 prices[0] = 1
   * <p>
   * 在此处卖出 prices[3] = 8
   * <p>
   * 在此处买入 prices[4] = 4
   * <p>
   * 在此处卖出 prices[5] = 9
   * <p>
   * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
   *
   * @param prices
   * @param fee
   * @return
   */

  public static int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    if (n == 1) {
      return 0;
    }
    int have = prices[0] * -1;
    int not_have = 0;
    for (int i = 1; i < n; ++i) {
      int a = have;
      int b = not_have;
      // have = a > b - prices[i] ? a : b - prices[i];
      have = Math.max(a, b - prices[i]);
      // not_have = a - fee + prices[i] > b ? a - fee + prices[i] : b;
      not_have = Math.max(a - fee + prices[i], b);
    }
    return Math.max(have, not_have);
  }

  public static void main(String[] args) {
    int[] prices = {1, 3, 2, 8, 4, 9};
    int fee = 2;
    log.info("maxProfit : {}", maxProfit(prices, fee));
  }
}
