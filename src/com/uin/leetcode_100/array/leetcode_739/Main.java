package com.uin.leetcode_100.array.leetcode_739;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. 每日温度
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，
 * 其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。
 */
public class Main {
    /**
     * 遍历
     *
     * @param temperatures
     * @return int[]
     * @author wanglufei
     * @date 2022/8/18 4:29 PM
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];
            if (cur < 100) {
                for (int j = i + 1; j < temperatures.length; j++) {
                    if (temperatures[i] < temperatures[j]) {
                        res[i] = j - i;
                        break;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 单调栈
     *
     * @param temperatures
     * @return int[]
     * @author wanglufei
     * @date 2022/8/18 4:34 PM
     */
    public int[] solutions(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
