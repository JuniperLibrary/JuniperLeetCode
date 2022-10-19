package com.uin.leetcode_100.slidingwindow.leetcode_904;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * <p>
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * <p>
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * <p>
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 */
public class Main {
    //双指针
    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        }

        int res = 0;
        int left = 0;
        int right = 1;

        int l = fruits[left];
        int r = fruits[right];

        while (right < fruits.length) {
            if (fruits[right] == r || fruits[right] == l) {
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                left = right - 1;
                l = fruits[left];
                r = fruits[right];
                while (left >= 1 && fruits[left - 1] == l) {
                    left--;
                }
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }

    /**
     * 我们可以使用滑动窗口解决本题，left和right分别表示满足要求的窗口的左右边界，同时我们使用哈希表存储这个窗口内的数以及出现的次数。
     * 我们每次将right移动一个位置，并将fruits[right]加入哈希表。如果此时哈希表不满足要求（即哈希表中表现超过两个键值对），
     * 那么我们需要不断移动left，并将fruits[left],并将fruits[left]从哈希表中移除，直到哈希表要满足要求为止。
     * 需要注意的是，将fruits[left]从哈希表中移除后，如果fruits[left]在哈希表中的出现次数减少为0，需要将对应的键值对从哈希表中移除。
     *
     * @param fruits
     * @return
     */
    //滑动窗口
    public static int slidingWindow(int[] fruits) {
        // 存放滑动窗口采摘水果，窗口最大值为2
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            // count为水果最大数目，当map大小超过2时，滑窗需前移left;
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] fruits = {0, 1, 2, 2};
        System.out.println(slidingWindow(fruits));
    }
}
