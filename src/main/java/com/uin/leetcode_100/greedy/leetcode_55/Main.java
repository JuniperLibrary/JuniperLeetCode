package main.java.com.uin.leetcode_100.greedy.leetcode_55;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class Main {
    public boolean canJump(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            int cur = nums[i] + i;
            max = Math.max(max, cur);
        }
        return max > nums.length - 1;
    }

    /**
     * 贪心
     *
     * @param nums
     * @return boolean
     * @author wanglufei
     * @date 2022/9/9 11:13 PM
     */
    public static boolean helper(int[] nums) {
        int n = nums.length;
        int rightmost = 0;

        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(helper(nums));
    }
}
