package com.uin.day;

import cn.hutool.json.JSONUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 1726 同积元组
 * <p>
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。
 * <p>
 * 其中 a、b、c 和 d 都是 nums 中的元素，且 a!= b != c != d
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,4,6]
 * <p>
 * 输出：8
 * <p>
 * 解释：存在 8 个满足题意的元组： (2,6,3,4) , (2,6,4,3) , (6,2,3,4) ,
 * <p>
 * (6,2,4,3) (3,4,2,6) , (4,3,2,6) ,
 * <p>
 * (3,4,6,2), (4,3,6,2)
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,4,5,10]
 * <p>
 * 输出：16
 * <p>
 * 解释：存在 16 个满足题意的元组： (1,10,2,5) , (1,10,5,2) , (10,1,2,5) ,
 * <p>
 * (10,1,5,2) (2,5,1,10) , (2,5,10,1) ,
 * <p>
 * (5,2,1,10) , (5,2,10,1) (2,10,4,5) ,
 * <p>
 * (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
 * <p>
 * (4,5,2,10) , (4,5,10,2), (5,4,2,10) ,
 * <p>
 * (5,4,10,2)
 *
 * @author lin.liu
 */

@Slf4j
public class LeetCode1726 {

  public int tupleSameProduct(int[] nums) {
    // a * b = c * d
    // a!= b != c != d

    // 组合
    // 假设有一个长度为 4 的数组 按照以上条件 这样的组合 总共有
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        int x = nums[i] * nums[j];
        cnt.merge(x, 1, Integer::sum);
      }
    }
    int ans = 0;
    for (int value : cnt.values()) {
      ans += value * (value - 1) / 2;
    }
    return ans << 3;
  }

  public static int tupleSameProduct2(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int key = nums[i] * nums[j];
        cnt.put(key, cnt.getOrDefault(key, 0) + 1);
      }
    }
    log.info("cnt:{}",JSONUtil.parse(cnt));
    int ans = 0;
    for (Integer value : cnt.values()) {
      ans += value * (value - 1) * 4;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 4, 6};
    log.info("同积元组:{}",tupleSameProduct2(nums));
  }
}
