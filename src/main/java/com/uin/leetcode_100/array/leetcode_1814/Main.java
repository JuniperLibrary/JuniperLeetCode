package main.java.com.uin.leetcode_100.array.leetcode_1814;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. 统计一个数组中好对子的数目
 * 给你一个数组nums，数组中只包含非负整数。定义rev(x)的值为将整数x各个数字位反转得到的结果。比方说rev(123) = 321，rev(120) = 21。我们称满足下面条件的下标对(i, j) 是好的：
 * <p>
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对109 + 7取余后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 * - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 * - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * 示例 2：
 * <p>
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-nice-pairs-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        countNicePairs(new int[]{42, 11, 1, 97});
    }

    public static int countNicePairs(int[] nums) {
        // nums[i]+rev(j)=nums[j]+rev(i)
        // nums[i]-rev(i)=nums[j]-rev(j)
        // f(i)=f(j)
        final int MOD = 1000000007;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            int temp = i, j = 0;
            while (temp > 0) {

                j = j * 10 + temp % 10;
                temp /= 10;
            }
            res = (res + map.getOrDefault(i - j, 0)) % MOD;
            map.put(i - j, map.getOrDefault(i - j, 0) + 1);
        }
        return res;
    }
}
