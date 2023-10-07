package com.uin.day;

import java.util.ArrayDeque;
import java.util.Deque;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lin.liu
 */
@Slf4j
public class StockSpanner {

  /**
   * 901 股票价格跨度
   * <p>
   * 设计一个算法某些股票的每日报价 并返回该股票当日价格的跨度
   * <p>
   * 当日股票的价格的跨度 被定义为股票价格小于或等于今天价格的最大连续日数 从今天开始回数 包括今天  (pre_day,now_day]
   * <p>
   * 例如 如果未来7天股票的价格是 [100,80,60,70,60,75,85]
   *                          [0,  1, 2, 3, 4, 5, 6]
   * <p>
   * 那么跨度将是[1,1,1,2,1,4,6]
   * <p>
   * 实现 StockSpanner 类：
   * <p>
   * StockSpanner() 初始化类对象。 int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
   * <p>
   * 输入： ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"] [[], [100], [80],
   * [60], [70], [60], [75], [85]]
   * <p>
   * 输出： [null, 1, 1, 1, 2, 1, 4, 6]
   * <p>
   * 解释： StockSpanner stockSpanner = new StockSpanner();
   * <p>
   * stockSpanner.next(100); // 返回 1
   * <p>
   * stockSpanner.next(80);  // 返回 1
   * <p>
   * stockSpanner.next(60);  // 返回 1
   * <p>
   * stockSpanner.next(70);  // 返回 2
   * <p>
   * stockSpanner.next(60);  // 返回 1
   * <p>
   * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
   * <p>
   * stockSpanner.next(85);  // 返回 6
   */

  /**
   * 根据题目描述 我们可以知道 对于当日价格 price 从这个价格开始往前找，找到第一个比这个价格大的价格 这两个价格的下标差 cnt 就是当日价格的跨度
   */
  // [price,cnt]
  private static Deque<int[]> stack = new ArrayDeque<>();

  public StockSpanner() {
    // TODO document why this constructor is empty
  }

  public int next(int price) {
    // TODO document why this method is empty
    int cnt = 1;
    while (!stack.isEmpty() && stack.peek()[0] <= price) {
      cnt += stack.pop()[1];
    }
    stack.push(new int[]{price, cnt});
    return cnt;
  }

  public static void main(String[] args) {
    StockSpanner stockSpanner = new StockSpanner();
    log.info("跨度：{}", stockSpanner.next(85));
  }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * <p>
 * StockSpanner obj = new StockSpanner();
 * <p>
 * int param_1 = obj.next(price);
 */