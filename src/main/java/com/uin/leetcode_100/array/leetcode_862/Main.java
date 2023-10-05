package main.java.com.uin.leetcode_100.array.leetcode_862;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 862.和至少为k的子数组
 * 给你一个整数数组nums和一个整数k，找出nums中和至少为k的最短子数组，并返回该子数组的长度。如果不存在这样的子数组返回-1；
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        System.out.println(shortestSubarray(nums, k));
    }

    /**
     * 前缀和+队列
     *
     * @param nums
     * @param k
     * @return
     */
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // -1,2,2
//        Arrays.sort(nums);
//
//        int left = 0, right = n - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[left] + nums[mid] > k && mid != left) {
//                mid
//            }
//        }
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }

        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            long curSum = preSumArr[i];

            while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }
}
