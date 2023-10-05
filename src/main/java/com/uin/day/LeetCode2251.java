package main.java.com.uin.day;

import cn.hutool.json.JSONUtil;
import java.util.Arrays;

/**
 * @author lin.liu
 */
public class LeetCode2251 {

  public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
    // 2251 花期内花的数目
    // flowers[i] = [start,end] 表示第 i 个花的花期从 start 到 end
    // 同时给你一个下标从 0 开始大小为 n 的整数数组 people people[i]表示第 i 个人来看花的时间
    // 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i] 是第 i 个人到达时在花期内的数目

    int n = flowers.length;
    int[] start = new int[n]; //[1,3,9,4]
    int[] end = new int[n]; //[6,7,12,13]

    for (int i = 0; i < n; i++) {
      start[i] = flowers[i][0];
      end[i] = flowers[i][1];
    }

    Arrays.sort(start); //[1,3,4,9]
    Arrays.sort(end); // [6,7,12,13]

    int m = people.length;
    int[] ans = new int[m];

    for (int i = 0; i < m; i++) {
      ans[i] = search(start, people[i] + 1) - search(end, people[i]);
    }
    return ans;
  }

  /**
   * 使用二分查找来找到它们到达时在花期内花的数目
   * <p>
   * 找出在每个人到达时，已经开花的花的数目，减去在每个人到达时，已经凋谢的花的数目
   *
   * @param nums
   * @param x
   * @return
   */
  private static int search(int[] nums, int x) {
    int l = 0;
    int r = nums.length;
    while (l < r) {
      int mid = (l + r) >> 1;
      if (nums[mid] >= x) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  public static void main(String[] args) {
    int[][] flowers = {{1, 6}, {3, 7}, {9, 12}, {4, 13}};
    int[] people = {2, 3, 7, 11};
    int[] ints = fullBloomFlowers(flowers, people);
    System.out.println(JSONUtil.toJsonStr(ints));
    int[] ans = {1, 2, 2, 2};
  }
}
