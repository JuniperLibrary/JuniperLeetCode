package com.uin.day;

import lombok.extern.slf4j.Slf4j;

/**
 * 2520 统计能被整除数字的位数
 */
@Slf4j
public class LeetCode2520 {

  public static int countDigits(int num) {
    int ans = 0;
    for (int x = num; x > 0; x /= 10) {
      if(num % (x % 10) ==0){
        ++ans;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    log.info("统计能被整除数字的位数:{}",countDigits(121));
  }
}
