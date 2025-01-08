package com.dingchuan.lc2517;

import java.util.*;
import lombok.extern.slf4j.*;

@Slf4j
public class MaximumTastiness {

  public static void main(String[] args) {
    log.info("礼盒的最大甜蜜度:{}",new MaximumTastiness().maximumTastiness(new int[]{13,5,1,8,21,2},3));
  }

  public int maximumTastiness(int[] price, int k) {
    Arrays.sort(price);

    int left =0;
    int right = price[price.length -1] -price[0];

    while (left < right){
      int mid = (left + right + 1) / 2;
      if (check(price, k, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  public boolean check(int[] price, int k, int tastiness) {
    int prev = Integer.MIN_VALUE / 2;
    int cnt = 0;
    for (int p : price) {
      if (p - prev >= tastiness) {
        cnt++;
        prev = p;
      }
    }
    return cnt >= k;
  }
}
