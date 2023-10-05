package com.uin.dp.maxProfit;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * @author wanglufei
 * @date 2022/5/31 12:54 PM
 */
public class Main {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4, 5};

        /**
         * 输入：prices = [1,2,3,4,5]
         * 输出：4
         * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出,
         *      这笔交易所能获得利润 = 5-1 = 4 。
         *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
         *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
         */

        /**
         * 解决的是最多交易两次的情况下所能获取的最大的利润
         * @author wanglufei
         */

        //最低的时候买入、最高的时候卖出
        int solution = solution(nums);
        System.out.println(solution);


    }

    public static int solution(int nums[]) {
        int length = nums.length;


        //初始化状态
        //dp[i][j] 表示的是在j天结束之后最多交易i次所能获得的最大利润
        //很明显 i=0或1或2
        int dp[][] = new int[3][length];


        //base case 边界条件

        //k是交易的次数，从1开始，如果是0表示没有交易，这个不需要计算
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j < length; j++) {
                for (int k = j - 1; k >= 0; k--) {
                    int max = 0;
                    if (k == 0) {
                        // 递推公式的边界条件判断，k等于0表示在第一天买入，第j天卖出，这种情况下我们最多
                        // 进行一次股票交易，所以不需要dp[i - 1][k - 1]。
                        max = Math.max(dp[i][j - 1], nums[j] - nums[k]);
                    } else {
                        //递推公式
                        //要么第j天不进行任何操作，要么第j天卖出一支股票。如果卖出股票我们需要找到卖出
                        //股票的最大利润(注意这里k不一定是买入股票最低价的那天，这里的最大利润还需要
                        //包含前面交易的利润，所以是nums[j] - nums[k] + dp[i - 1][k - 1])
                        max = Math.max(dp[i][j - 1], nums[j] - nums[k] + dp[i - 1][k - 1]);
                    }
                    dp[i][j] = Math.max(dp[i][j], max);
                }
            }
        }
        return dp[2][length - 1];
    }
}
