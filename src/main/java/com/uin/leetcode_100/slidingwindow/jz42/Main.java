package main.java.com.uin.leetcode_100.slidingwindow.jz42;

/**
 * 滑动窗口
 * 比如，给定arr=[1,2,3,4]，n=2，则其连续子数组的最大和为7。其长度为2的连续子数组为[1,2],[2,3],[3,4]，和最大就是3+4=7。
 * 要求时间复杂度为O(n)。
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(maxSubSum(nums, 2));
    }

    private static int maxSubSum(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // sum标记窗口的内元素的和
        int sum = 0;
        //maxSum 标记sum的最大值
        int maxSum = 0;
        // 滑动窗口的左右指针
        int left = 0, right = 0;
        for (; right < len; ) {
            // 右侧入窗 增大窗口
            sum += nums[right];
            right++;
            if (maxSum < sum) {
                maxSum = sum;
            }
            // 满足条件，左侧出窗，缩小窗口
            for (; right - left >= k && left < right; ) {
                sum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }
}
