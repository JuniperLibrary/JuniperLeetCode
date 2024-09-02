package com.dingchuan.lc2024;

/**
 * 2024. 考试的最大困扰度
 */
public class lc2024 {

  public int maxConsecutiveAnswers(String answerKey, int k) {
    return Math.max(maxConsecuitveChar(answerKey, k, 'T'), maxConsecuitveChar(answerKey, k, 'F'));
  }

  public int maxConsecuitveChar(String answerKey, int k, char ch) {
    int n = answerKey.length();
    int ans = 0;
    for (int left = 0, right = 0, sum = 0; right < n; right++) {
      sum += answerKey.charAt(right) != ch ? 1 : 0;
      while (sum > k) {
        sum -= answerKey.charAt(left++) != ch ? 1 : 0;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

  /**
   * 传入参数 ch 表示当前要检查的字符（'T' 或 'F'）。 使用滑动窗口技术： left 和 right 表示窗口的左右边界。
   * <p>
   * 1、 count 表示窗口中不等于 ch 的字符个数（需要被替换的字符数）。
   * <p>
   * 2、 当 count 超过 k 时，收缩左边界（left++），直到窗口中的 count 小于等于 k。
   * <p>
   * 3、 更新 maxLen 为当前窗口的最大长度。
   */

  private int maxConsecutiveChar(String answerKey, int k, char ch) {
    int left = 0, right = 0, maxLen = 0, count = 0;

    while (right < answerKey.length()) {
      if (answerKey.charAt(right) != ch) {
        count++;
      }

      while (count > k) {
        if (answerKey.charAt(left) != ch) {
          count--;
        }
        left++;
      }

      maxLen = Math.max(maxLen, right - left + 1);
      right++;
    }

    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(new lc2024().maxConsecutiveAnswers("TTFF", 2));
  }
}
