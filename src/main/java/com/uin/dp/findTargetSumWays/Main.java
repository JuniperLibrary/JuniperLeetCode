package main.java.com.uin.dp.findTargetSumWays;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * @author wanglufei
 * @date 2022/6/5 11:25 PM
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        /**
         * 我们假设在一些数组的前面加上 + ，得到的数字和 plusSum
         * 在一些数字的前面 - ，得到的数字差 minusSum。
         *
         * 我们想要的结果就是：plusSum-minusSum=target;
         * 假设数组中的所有元素的和是sum：plusSum + minusSum=sum;
         */
        //有上面的两个公式：
        /**
         * minusSum*2=sum - target; sum - target就必须为整数
         */
        // 1.如果不为整数，就直接返回0
        // 2.如果为整数，只需要找出一些数字让他们的和 等于minusSum，
        // 也就是(sum-target)/2的方案数
        int solution = solution(nums, target);
        System.out.println(solution);
    }

    public static int solution(int[] nums, int target) {
        //1.定义dp[i][j]表示从数组前i个元素中选取一些数字，让他们的和等于j的方案数。
        int length = nums.length;
        //1.1 求数组的和
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        // 如果所有数字的和小于target，或者sum - target是奇数，
        // 说明无论怎么添加符号，表达式的值都不可能是target
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }

        // 我们要找到一些元素让他们的和等于capacity的方案数即可。
        int solution = (sum - target) / 2;

        // dp[i][j]表示在数组nums的前i元素中选择一些元素，
        // 使得选择的元素之和等于j的方案数
        int[][] dp = new int[length + 1][solution + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= solution; j++) {
                //递推条件
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //2.最终只需要返回dp[length][(sum-target)/2]即可。
        return dp[length][solution];
    }
}
