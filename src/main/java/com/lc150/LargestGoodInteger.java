package com.lc150;

import lombok.extern.slf4j.*;

@Slf4j
public class LargestGoodInteger {

  public String largestGoodInteger(String num) {
    int n = num.length();
    String res = "";
    for (int i = 0; i < n - 2; i++) {
      if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
        String current = num.substring(i, i + 3);
        if (res.compareTo(current) < 0) {
          res = current;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    log.info("字符串中最大的 3 位相同数字:{}", new LargestGoodInteger().largestGoodInteger("6777133339"));
  }
}
