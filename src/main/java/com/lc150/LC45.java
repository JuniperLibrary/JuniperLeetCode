package com.lc150;

public class LC45 {

  public int jump(int[] nums) {
    int n = nums.length;

    // 用于存储到达每个位置所需的最小跳跃次数
    int[] dp = new int[n];
    // 初始化 dp 数组：将 dp[0] 设为 0，表示从初始位置到达第一个位置不需要跳跃
    dp[0] = 0;
    // 初始化 dp 数组：将 dp[i] 设为 n，表示从初始位置到达第 i 个位置需要跳跃次数为 n
    for (int i = 1; i < n; i++) {
      dp[i] = n;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        // 如果从第 j 个位置可以到达第 i 个位置，更新 dp[i]
        if (j + nums[j] >= i) {
          // 如果条件满足，说明可以从位置 j 跳跃至位置 i，此时计算从起始位置到位置 i 的最小跳跃次数为 dp[j] + 1（dp[j] 是到达位置 j 的最小跳跃次数，加上从 j 跳到 i 的这次跳跃）
          // 将此结果与当前 dp[i] 值进行比较，取两者之间的较小值作为新的 dp[i] 值。
          // 这一步确保了 dp[i] 始终记录着到达位置 i 的已知最小跳跃次数。
          dp[i] = Math.min(dp[i], dp[j] + 1);
        }
      }
    }
    // 即从起始位置到达数组最后一个位置所需的最小跳跃次数
    return dp[n - 1];
  }

  public int jumpGreedy(int[] nums){
    int n = nums.length;
    // 记录当前已用的跳跃次数，初始值为 0
    int steps = 0;
    // 当前可达到的最远位置
    int maxReach =0;
    // 下一次跳跃时可达到的最远位置
    int nextMaxReach = 0;

    for (int i = 0; i < n - 1; i++) {
      // 更新下一次跳跃时的最远位置
      nextMaxReach = Math.max(nextMaxReach, i + nums[i]);
      // 如果当前位置等于当前可达到的最远位置，说明需要跳跃一次，更新当前可达到的最远位置为下一次跳跃时的最远位置
      if (i == maxReach){
        steps++;
        maxReach = nextMaxReach;
      }
    }

    if(maxReach < n-1){
      return -1;
    }else {
      return steps+1;
    }
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 1, 4};
    System.out.println(new LC45().jump(nums));
  }
}
