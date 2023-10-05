package main.java.com.uin.double_weekend.weenkend_99.leetcode_6312;

public class Main {

  public static void main(String[] args) {
    System.out.println(splitNum(687));
  }

  public static int splitNum(int num) {
    int sum = 0, c[] = ("" + num).chars().sorted().toArray();
    for (int i = c.length - 1, j = 1; i >= 0; i -= 2, j *= 10) {
      sum += j * (c[i] - '0' + (i > 0 ? c[i - 1] - '0' : 0));
    }
    return sum;
  }
}
