package com.lc150;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC121 {

  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0) {
      return 0;
    }
    int minPrice = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < n; i++) {
      // 找到最低的买入价格
      minPrice = Math.min(minPrice, prices[i]);
      // 找到最大的利润
      maxProfit = Math.max(maxProfit, prices[i] - minPrice);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    LC121 lc121 = new LC121();
    int maxProfit = lc121.maxProfit(prices);
  }
}
