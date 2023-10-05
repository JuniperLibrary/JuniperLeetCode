package main.java.com.uin.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingchuan
 */
public class LeetCode_2178 {

  public static void main(String[] args) {
    System.out.println(maximumEvenSplit(12));
  }

  public static List<Long> maximumEvenSplit(long finalSum) {
    List<Long> res = new ArrayList<>();
    if (finalSum % 2 > 0) {
      return res;
    }
    for (long i = 2; i <= finalSum; i += 2) {
      res.add(i);
      finalSum -= i;
    }
    res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
    return res;
  }
}
