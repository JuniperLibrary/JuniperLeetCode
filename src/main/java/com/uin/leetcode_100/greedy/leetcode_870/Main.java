package main.java.com.uin.leetcode_100.greedy.leetcode_870;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 870. 优势洗牌
 * 给定两个大小相等的数组nums1和nums2，nums1相对于 nums的优势可以用满足nums1[i] > nums2[i]的索引 i的数目来描述。
 * 返回 nums1的任意排列，使其相对于 nums2的优势最大化。
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 */
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15}, nums2 = {1, 10, 4, 11};
        System.out.println(advantageCount(nums1, nums2));
    }

    /**
     * 二分
     *
     * @param nums1
     * @param nums2
     * @return int[]
     * @author wanglufei
     * @date 2022/10/8 9:48 AM
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        // nums1相对于 nums2的优势可以用满足nums1[i] > nums2[i]的索引 i的数目来描述。
        // 返回 nums1的任意排列，使其相对于 nums2的优势最大化。
        Arrays.sort(nums1);
        List<Integer> nums1_sort = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        int[] result = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            int index = binarySearchFirstIndexGreaterThanTarget(nums1_sort, nums2[i]);
            int removeIndex = index == -1 ? 0 : index;
            result[i] = nums1_sort.get(removeIndex);
            nums1_sort.remove(removeIndex);
        }
        return result;
    }

    private static int binarySearchFirstIndexGreaterThanTarget(List<Integer> nums1_sort, int target) {
        int left = 0, right = nums1_sort.size() - 1;
        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            if (nums1_sort.get(mid) > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums1_sort.get(left) > target) {
            return left;
        }
        if (nums1_sort.get(right) > target) {
            return right;
        }
        return -1;
    }

    public static int[] greedHelp(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //存放num1的元素
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[n];
        //遍历num2
        for (int i = 0; i < nums2.length; i++) {
            //找到大于 nums[i]的最小元素 略胜一筹
            Integer higher = map.higherKey(nums2[i]);
            //没有取 num1 中的最小值
            if (higher == null) {
                higher = map.firstKey();
            }
            ans[i] = higher;
            if (map.get(higher) == 1) {
                map.remove(higher);
            } else {
                map.put(higher, map.get(higher) - 1);
            }
        }
        return ans;
    }

    public static int[] helper(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }
}
