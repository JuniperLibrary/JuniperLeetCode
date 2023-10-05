package main.java.com.uin.leetcode_100.array.LeetCode_75;

/**
 * LeetCode 75 颜色分类
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 */
public class Main {
    public void colorSort(int[] nums) {
        //双指针
        int left = 0;
        int right = nums.length - 1;
        //移动的指针
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                i++;
                left++;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                //i++ 有可能换回来的是0 所以不能i++
                right--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
