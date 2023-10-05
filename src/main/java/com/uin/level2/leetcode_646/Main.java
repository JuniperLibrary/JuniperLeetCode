package main.java.com.uin.level2.leetcode_646;

import java.util.Arrays;
import java.util.Map;

/**
 * 646. 最长数对链
 * 给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 */
public class Main {
    /**
     * dp
     *
     * @param pairs
     * @return int
     * @author wanglufei
     * @date 2022/9/3 8:52 AM
     */
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 贪心
     *
     * @param pairs
     * @return int
     * @author wanglufei
     * @date 2022/9/3 8:53 AM
     */
    public int greedySearch(int[][] pairs) {
        int curr = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        for (int[] pair : pairs) {
            if (curr < pair[0]) {
                curr = pair[1];
                res++;
            }
        }
        return res;
    }
}
