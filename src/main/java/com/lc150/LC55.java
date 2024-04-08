package com.lc150;
// 55 跳跃游戏
// 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 10⁵
//
//
// Related Topics 贪心 数组 动态规划 👍 2714 👎 0

public class LC55 {

  public boolean canJump(int[] nums) {
    int n = nums.length;
    int maxPos = 0;
    for (int i = 0; i < n; i++) {
      // 在每次循环中，先检查当前索引 i 是否小于等于当前最大可达位置 maxPos。
      // 这是为了确保不会考虑超出当前跳跃范围的位置。
      if (i <= maxPos) {
        // 如果满足条件，则进行以下操作：
        // 计算新的可达距离：将当前索引 i 加上对应元素值 nums[i]，得到当前位置可以跳跃到的新距离。
        // 更新 maxPos：使用 Math.max() 函数比较原 maxPos 值与新计算出的距离，取两者中的较大值作为新的 maxPos。
        // 这样，maxPos 总是保持当前已知的最大可达位置。
        maxPos = Math.max(maxPos, i + nums[i]);
        // 在更新 maxPos 后，检查 maxPos 是否大于等于 n - 1。这表示玩家已经能够跳跃到数组的最后一个位置。
        // 若是，则说明游戏可以胜利，直接返回 true 表示可以跳到数组末尾。
        if (maxPos >= n - 1) {
          return true;
        }
      }
    }
    return false;
  }
  public static void main(String[] args) {
    LC55 lc55 = new LC55();
    System.out.println(lc55.canJump(new int[]{2, 3, 1, 1, 4}));
  }
}
