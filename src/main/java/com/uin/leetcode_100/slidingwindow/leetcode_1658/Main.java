package com.uin.leetcode_100.slidingwindow.leetcode_1658;

import java.util.Arrays;

/**
 * 1658. 将 x 减到 0 的最小操作数
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x恰好 减到0 ，返回 最小操作数 ；否则，返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public int minOperations(int[] nums, int x) {
        // 移除只能是最左边或者最右边
        // 与x做差得0 得最少次数

        // 记数组的长度为 nn，我们可以用 left 和 right 分别表示选择的前缀以及后缀的边界
        // 如果 left=−1，表示我们选择了空前缀；如果 right=n，表示我们选择了空后缀。

        // 由于数组 nums 中的元素均为正数，因此当 left 向右移动（即前缀的范围增加）时，
        // 它们的和是严格递增的。要想将它们的和控制在 x，我们必须要将 right 向右移动。
        // 这样一来，我们就可以用滑动窗口的方法解决本题。

        // 初始时，left 的值为 -1，right 为 0，表示选择了空前缀以及整个数组作为后缀。

        // 我们用 lsum 和 rsum 分别记录前缀以及后缀的和，那么：
        // 如果 lsum + rsum = x，说明我们找到了一组答案，对应的操作次数为 (left+1)+(n−right)；
        // 如果 lsum + rsum > x，说明和过大，我们需要将 right 向右移动一个位置；
        // 如果 lsum + rsum < x，说明和过小，我们需要将 left 向右移动一个位置。

        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum < x) {
            return -1;
        }

        int right = 0;
        int lSum = 0, rSum = sum;
        int ans = n + 1;

        for (int left = -1; left < n; ++left) {
            if (left != -1) {
                lSum += nums[left];
            }
            while (right < n && lSum + rSum > x) {
                rSum -= nums[right];
                ++right;
            }
            if (lSum + rSum == x) {
                ans = Math.min(ans, (left + 1) + (n - right));
            }
        }

        return ans > n ? -1 : ans;
    }
}
