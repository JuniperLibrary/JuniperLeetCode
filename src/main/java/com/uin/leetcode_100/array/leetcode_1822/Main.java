package main.java.com.uin.leetcode_100.array.leetcode_1822;

/**
 * 1822.数组元素积的符号
 * 已知函数signFunc(x) 将会根据 x 的正负返回特定值：
 * <p>
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * <p>
 * 返回 signFunc(product) 。
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -3, -4, 3, 2, 1};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] < 0) {
                ans = -ans;
            }
        }
        return ans;
    }
}
