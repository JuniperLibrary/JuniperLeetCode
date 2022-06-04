package com.uin.dp.maxProfit;

public class Main1 {

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4, 5};
        int solution = solution(nums);
        System.out.println(solution);

    }

    public static int solution(int[] prices) {
        //定义dp[i][j][k]
        //表示在第i天交易结束后，最多进行j次交易所获得的最大利润。
        //注意这 里的k要么是0，要么是1。0表示手里没有股票，1表示手里有一支股票。
        //dp[i][j][0]:表示第i天交易结束之后，最多进行j次交易，并且手里没有股票的最大利润。
        //dp[i][j][1]:表示第i天交易结束之后，最多进行j次交易，并且手里持有股票的最大利润。

        int len = prices.length;
        int[][][] dp = new int[len][3][2];

        dp[0][0][0] = 0;//第一天没进行任何买卖
        dp[0][0][1] = -prices[0];//第一天买入一支股票
        //第一天不可能有下面4种情况，所以是无效的
        dp[0][1][0] = Integer.MIN_VALUE / 2;

        dp[0][1][1] = Integer.MIN_VALUE / 2;
        dp[0][2][0] = Integer.MIN_VALUE / 2;
        dp[0][2][1] = Integer.MIN_VALUE / 2;

        for (int i = 1; i < prices.length; i++) { //递推公式
            //dp[i][0][0] = 0; 这个可以省略
            dp[i][1][0] = Math.max(dp[i - 1][0][1] + prices[i], dp[i - 1][1][0]);
            dp[i][2][0] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][2][0]);
            dp[i][0][1] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][0][1]);
            dp[i][1][1] = Math.max(dp[i - 1][1][0] - prices[i], dp[i - 1][1][1]);
            //dp[i][2][1]:无效
        }
        //要么没交易，要么交易一次，要么交易两次，取最大值即可
        return Math.max(dp[prices.length - 1][0][0],
                Math.max(dp[prices.length - 1][1][0], dp[prices.length - 1][2][0]));
    }
}
