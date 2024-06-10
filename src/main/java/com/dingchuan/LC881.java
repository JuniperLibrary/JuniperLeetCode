package com.dingchuan;

import java.util.Arrays;

/**
 * 881. 救生艇
 * <p>
 * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回 承载所有人所需的最小船数 。
 * <p>
 * 输入：people = [1,2], limit = 3
 * <p>
 * 输出：1
 * <p>
 * 解释：1 艘船载 (1, 2)
 *
 * @author dingchuan
 */
public class LC881 {

  public int numRescueBoats(int[] people, int limit) {
    int ans = 0;
    int n = people.length;
    Arrays.sort(people);
    int left = 0, right = n - 1;

    while (left <= right) {
      // 轻的船可以和重 ship 配对
      if (people[left] + people[right] <= limit) {
        left++;
      }
      // 轻的 ship 无法和重 ship 配对
      right--;
      ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] people = {3, 2, 2, 1};
    int limit = 3;
    System.out.println(new LC881().numRescueBoats(people, limit));
  }
}
