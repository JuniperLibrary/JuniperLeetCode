package com.dingchuan;

/**
 * 100305. K 秒后第 N 个元素的值 给你两个整数 n 和 k。
 * <p>
 * 最初，你有一个长度为 n 的整数数组 a，对所有 0 <= i <= n - 1，都有 a[i] = 1
 * 。每过一秒，你会同时更新每个元素为其前面所有元素的和加上该元素本身。例如，一秒后，a[0] 保持不变，a[1] 变为 a[0] + a[1]，a[2] 变为 a[0] + a[1] +
 * a[2]，以此类推。
 * <p>
 * 返回 k 秒后 a[n - 1] 的值。
 * <p>
 * 由于答案可能非常大，返回其对 109 + 7 取余 后的结果。
 * <p>
 * 输入：n = 4, k = 5
 * <p>
 * 输出：56
 * <p>
 * 解释：
 * <p>
 * 时间（秒）	数组状态
 * <p>
 * 0	[1,1,1,1]
 * <p>
 * 1	[1,2,3,4]
 * <p>
 * 2	[1,3,6,10]
 * <p>
 * 3	[1,4,10,20]
 * <p>
 * 4	[1,5,15,35]
 * <p>
 * 5	[1,6,21,56]
 */
public class LC100305 {

  public int valueAfterKSeconds(int n, int k) {
    // 模数
    int MOD = 1000000007;
    // 初始化长度为 n 的数组 a，所有元素都为 1
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = 1;
    }

    // 模拟 k 秒的更新过程
    for (int sec = 0; sec < k; sec++) {
      // 创建一个新的数组 newA 来存储更新后的值
      int[] newA = new int[n];
      // 第一个元素 newA[0] 保持不变
      newA[0] = a[0];
      // 更新其他元素
      for (int i = 1; i < n; i++) {
        // newA[i] 等于前一个新元素的值加上当前元素 a[i] 的值，并对 MOD 取模
        newA[i] = (newA[i - 1] + a[i]) % MOD;
      }
      // 用 newA 更新数组 a
      a = newA;
    }

    // 返回 k 秒后数组的最后一个元素的值
    return a[n - 1];
  }

  public static void main(String[] args) {
    System.out.println(new LC100305().valueAfterKSeconds(4, 5));
  }
}
