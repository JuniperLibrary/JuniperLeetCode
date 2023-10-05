package com.uin.tuhu21.b1;

import java.util.Arrays;

/**
 * 途虎养车2021秋招Java笔试试卷B-双十一的购物车
 * SS是途虎养车的一名技术人员，她每年双11的时候，会尝试清空自己购物车中“看起来便宜”的商品。她的购物车列表是有序的，
 * 如果一件商品，其价格比购物车中前一个商品和后一个商品的价格都低，则SS认为这件商品“看起来便宜”。
 * 有一天，你趁她午睡且忘记锁屏登入了她的购物网站账号，想通过调整购物车顺序，来“帮助”她买到最多的的商品。
 * <p>
 * [1,2,3]
 * <p>
 * 1
 * <p>
 * 输入是一个整型数组，代表A现在购物车中的商品价格。
 * 输出经过重新排列之后，SS最多会购买的商品数量。示例中SS最多会购买1件商品（一个可能的排列为[3,1,2]）
 */
public class Main {
    public int reorder(int[] prices) {
        //1,3,3,4,5  分成2部分   看1 是否能插入[1,3] 和[3,4,5]
        Arrays.sort(prices);
        int n = prices.length;
        int left = 0, right = (n - 1) / 2;
        int mid = right;
        int count = 0;

        while (left < mid && right + 1 < n) {
            if (prices[left] < prices[right] && prices[left] < prices[right + 1]) {
                count++;
                right++;
            }
            left++;
        }
        return count;
    }
}
