package main.java.com.uin.dp.maxSubsequence;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 找到和最大的长度k的子序列
 * <p>
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 *
 * @author wanglufei
 * @date 2022/5/26 1:28 PM
 */
public class Main {
    public static void main(String[] args) {
        //[2,1,3,3]
        //2
        int[] nums = {2, 1, 3, 3};
        // len=4
        int k = 2;
        int[] solution = solution(nums, k);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] nums, int k) {
        int len = nums.length;//4
        if (len == 0) {
            return nums;
        }

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = nums[i];
        }
        Arrays.sort(dp);
        HashMap<Integer, Integer> map = new HashMap<>();
        // 4-2=2
        for (int i = len - k; i < len; i++) {
            //<key,value>
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (map.getOrDefault(nums[i], 0) > 0 && index < k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                res[index++] = nums[i];
            }
        }

        return res;
    }
}
