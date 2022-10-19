package com.uin.leetcode_100.dp.leetcode_902;

/**
 * 902. 最大为 N 的数字组合
 * 给定一个按非递减顺序排列的数字数组digits。你可以用任意次数digits[i]来写的数字。例如，如果digits = ['1','3','5']，我们可以写数字，如'13','551', 和'1351315'。
 * <p>
 * 返回 可以生成的小于或等于给定整数 n 的正整数的个数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = ["1","3","5","7"], n = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * 示例 2：
 * <p>
 * 输入：digits = ["1","4","9"], n = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 * 示例 3:
 * <p>
 * 输入：digits = ["7"], n = 8
 * 输出：1
 */
public class Main {
    public static void main(String[] args) {
        String[] digits = {"1", "3", "5", "7"};
        int n = 100;
    }

    /**
     * 设 n 是一个十进制的 k 位数，所有数字位数小于 k 且由digits 组成的数字则一定是小于 n 的。
     * 我们用 dp[i][0] 表示由 digits 构成且 n 的前 i 位的数字个数， dp[i][1]表示由 digits 构成且等于 n 的前 i 位的数字的个数，可知 dp[i][1] 的取值只能为0和1。
     * <p>
     * 例如 n = 2345 digits=["1","2","3","4"]
     * <p>
     * 则 dp[1][0],dp[2][0],dp[3][0],dp[4][0] 分别表示小于 2，23 ，234，2345的合法的个数，dp[1][1],dp[2][1],dp[3][1],dp[4][1]分别表示等于2，23，234，2345
     * 的合法的个数。
     * <p>
     * 设 digits 中的字符数目为 m 个，数字n的前j位构成的数字为 num[j] ,数字n的第j个字符为s[j],当遍历到n的第i位：
     * - 当满足i > 1时，此时任意数字d构成的数字一定满足 d<num[i] ;
     * - 设数字 a < num[i-1]，则此时在 a 的末尾追加一个数字 d 构成的数字为 a*10+d ,此时可以知道 d 取 0，1，。。。。，9中任意数字均满足小于 a*10+d < num[i]=num[i-1]*10+s[i];
     * - 设数字 a=num[i-1],则此时在 a 的末尾追加一个数字d构成的数为 a*10+d，此时可以知道 d < s[i]时，才能满足a*10+d<num[i]=num[i-1]*10+s[i]
     * - 初始化指令dp[0][1]=1,如果前i位中存在某一位j，对于任意整数d均不满足d=s[j],则此时dp[i][1]=0;
     * <p>
     * 我们计算出前k位小于n的数字的个数dp[k][0],前k位等于n的数字的个数dp[k][1],最终的答案为dp[k][0]+dp[k][1];
     *
     * @param digits
     * @param n
     * @return
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        // 怎么将字符串数组转换成整形数组
        String s = Integer.toString(n);

        int m = digits.length, k = s.length();
        int[][] dp = new int[k + 1][2];
        dp[0][1] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < m; j++) {
                if (digits[j].charAt(0) == s.charAt(i - 1)) {
                    dp[i][1] = dp[i - 1][1];
                } else if (digits[j].charAt(0) < s.charAt(i - 1)) {
                    dp[i][0] += dp[i - 1][1];
                } else {
                    break;
                }
            }

            if (i > 1) {
                dp[i][0] += m + dp[i - 1][0] * m;
            }
        }

        return dp[k][0] + dp[k][1];
    }
}
