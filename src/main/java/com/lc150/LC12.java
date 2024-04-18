package com.lc150;

public class LC12 {

  int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
  public String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.length; i++) {
      while (num >= values[i]) {
        num -= values[i];
        sb.append(symbols[i]);
      }
      if (num == 0) {
        break;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(new LC12().intToRoman(3));
  }

}
