package com.uin.leetcode_100.array.leetcode_347;


import java.util.*;

public class Main {
    public int[] topK(int[] nums, int k) {
        List<List<Integer>> buckets = new ArrayList<>();
        buckets.add(new ArrayList<>());

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            buckets.add(new ArrayList<>());
        }

        for (int num : counts.keySet()) {
            int count = counts.get(nums);
            buckets.get(count).add(num);
        }

        int[] res = new int[k];

        for (int i = buckets.size() - 1; i > 0; i--) {
            if (k <= 0) return res;
            if (buckets.get(i).size() == 0) continue;
            for (int num : buckets.get(i)) {
                res[--k] = num;
            }
        }
        return res;
    }

    public int[] help(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
