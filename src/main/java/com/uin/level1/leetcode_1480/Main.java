package main.java.com.uin.level1.leetcode_1480;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * @author wanglufei
 * @date 2022/8/12 3:29 PM
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = i + 1;
        }
        System.out.println(runningSum(nums));
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
