package com.uin.td.list;

import java.util.*;

/**
 * 出现次数大于等于数组长度一半的数
 *
 * @author wanglufei
 * @date 2022/8/11 7:34 PM
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(helper4(nums));
    }

    public static int helper(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;

        Arrays.sort(nums);

        int count = 0;
        int last = length / 2;
        int index = 0;

        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                count++;
                if (count >= last) {
                    index = i;
                }
            } else {
                set.add(nums[i]);
            }
        }
        return nums[index];
    }

    public static int helper2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int helper3(int[] nums) {
        Map<Integer, Integer> map = map(nums);
        Map.Entry<Integer, Integer> mapEntry = null;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (mapEntry == null || integerIntegerEntry.getValue() > mapEntry.getValue()) {
                mapEntry = integerIntegerEntry;
            }
        }
        return mapEntry.getKey();
    }

    public static Map<Integer, Integer> map(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map;
    }

    /**
     * 投票算法
     *
     * @param nums
     * @return int
     * @author wanglufei
     * @date 2022/8/12 11:26 AM
     */
    public static int helper4(int[] nums) {
        int x = 0;
        int counts = 0;
        for (int num : nums) {
            //如果票数和为0，我们假设num元素为众数
            if (counts == 0) {
                x = num;
            }
            //如果是众数票数+1，否则票数-1
            if (num == x) {
                counts++;
            } else {
                counts--;
            }
        }
        return x;
    }
}
