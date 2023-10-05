package main.java.com.uin.tuhu23.a2;

import java.util.Arrays;

/**
 * 【2023届途虎校招】Java开发工程师笔试01卷---机油刚好够
 */
public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param oils int整型一维数组
     * @param box  int整型
     * @return int整型
     */
    public int change(int[] oils, int box) {
        // write code here
        int max = box + 1;
        int[] dp = new int[box + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int curOils = 1; curOils <= box; curOils++) {
            for (int j = 0; j < oils.length; j++) {
                if (oils[j] <= curOils) {
                    dp[curOils] = Math.min(dp[curOils], dp[curOils - oils[j]] + 1);
                }
            }
        }
        return dp[box] > box ? -1 : dp[box];
    }
}
