package com.dingchuan.lc15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 */
public class lc15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    // 排序
    Arrays.sort(nums);
    // 取一个值遍历，其余的数使用两数之和
    int l = nums.length;
    for (int i = 0; i < l - 2; i++) {
      int x = nums[i];
      if (i > 0 && x == nums[i - 1]) {
        continue;
      }
      // 两项优化
      if (x + nums[i + 1] + nums[i + 2] > 0) {
        break;
      }
      if (x + nums[l - 2] + nums[l - 1] < 0) {
        continue;
      }
      // 套用双指针两数之和
      int left = i + 1;
      int right = l - 1;
      while (left < right) {
        int sum = x + nums[left] + nums[right];
        if (sum < 0) {
          left++;
        } else if (sum > 0) {
          right--;
        } else {
          ans.add(Arrays.asList(x, nums[left], nums[right]));
          // 循环跳过相同的第二个数，先加，后面while判断的时候需要-1
          do {
            left++;
          } while (nums[left - 1] == nums[left] && left < right);
          // 循环跳过相同的第三个数，先减，后面while判断的时候需要+1
          do {
            right--;
          } while (nums[right + 1] == nums[right] && left < right);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    lc15 lc15 = new lc15();
    System.out.println(lc15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }
}
