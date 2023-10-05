package main.java.com.uin.level2.leetcode_1636;

import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * <p>
 * 请你返回排序后的数组。
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
        System.out.println(frequencies(nums));
    }

    public static int[] frequencies(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int cnt1 = map.get(a), cnt2 = map.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
