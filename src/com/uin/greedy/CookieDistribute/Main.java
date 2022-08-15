package com.uin.greedy.CookieDistribute;

/**
 * LeetCode 455 分发饼干
 */

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 注意：
 * <p>
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3], [1,1]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * <p>
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 */
public class Main {
    public static void main(String[] args) {
        int[] hungry = {1, 2, 3};
        int[] cookies = {1, 1};
        int solution = solution(hungry, cookies);
        System.out.println(solution);
    }

    public static int solution(int[] hungry, int[] cookies) {
        Arrays.sort(hungry);
        Arrays.sort(cookies);
        int hun = 0;//胃口
        int sm = 0;//尺寸
        int res = 0;
        while (hun < hungry.length && sm < cookies.length) {
            //只有当饼干的尺寸 >= 胃口 ，才满足
            if (cookies[sm] >= hungry[hun]) {
                hun++;
                sm++;
                res++;
            } else {
                //饼干的尺寸 < 胃口 不满足 需要换人
                sm++;
            }
        }
        return res;
    }
}
