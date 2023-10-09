package com.uin.day;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author lin.liu
 */
public class StockPrice {

  /**
   * 2034 股票的价格波动
   * <p>
   * 每一条记录包含一个时间戳和该时间点对应的价格
   * <p>
   * 不巧的是 由于股票市场内存在波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录是错的。
   * <p>
   * 如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误记录
   */
  private Map<Integer, Integer> d = new HashMap<>();
  private TreeMap<Integer, Integer> ls = new TreeMap<>();
  private int last;

  public StockPrice() {

  }

  public void update(int timestamp, int price) {
    if (d.containsKey(timestamp)) {
      int old = d.get(timestamp);
      if (ls.merge(old, -1, Integer::sum) == 0) {
        ls.remove(old);
      }
    }
    d.put(timestamp, price);
    ls.merge(price, 1, Integer::sum);
    last = Math.max(last, timestamp);
  }

  public int current() {
    return d.get(last);
  }

  public int maximum() {
    return ls.lastKey();
  }

  public int minimum() {
    return ls.firstKey();
  }
}
/**
 * Your StockPrice object will be instantiated and called as such: StockPrice obj = new
 * StockPrice(); obj.update(timestamp,price); int param_2 = obj.current(); int param_3 =
 * obj.maximum(); int param_4 = obj.minimum();
 */