package com.lc150;

public class LC13 {

  public int romanToInt(String s) {
    int sum = 0;
    // 前一个值
    int preNum = getValue(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      int num = getValue(s.charAt(i));
      if (preNum < num) {
        // 减法
        sum -= preNum;
      } else {
        // 加法
        sum += preNum;
      }
      // 赋值
      preNum = num;
    }
    // 最后一个值
    sum += preNum;
    return sum;
  }

  private int getValue(char c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return 0;
    }
  }
}
