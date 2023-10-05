package main.java.com.uin.litteredbook.a1;

import java.util.Scanner;

/**
 * 薯券使用问题
 * 某小红薯在小红书的活动中抽奖中了一定价值的薯券，这些薯券可以用来购买一批商品，求有多少种购买组合。其中一件商品可以买多件。
 * 输 入:薯券金额、商品分别价格
 * 输出 :组合数
 * <p>
 * 输入薯券金额、商品分别价格
 * 例如：10 [2,3,5]
 * 10与[2,3,5]中间有空格
 * 输出4，则结果集可以为:2,2,2,2,2；5,5；2,3,5；2,2,3,3共有4种组合
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        String s = in.next();
        String[] split = s.substring(1, s.length() - 1).split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int x : nums) {
            for (int i = 0; i < dp.length; i++) {
                dp[i] = dp[i] + dp[i - x];
            }
        }

        System.out.println(dp[target]);
    }

    public static int helper(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= target; j++) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
