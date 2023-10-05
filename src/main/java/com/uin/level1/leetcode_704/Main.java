package main.java.com.uin.level1.leetcode_704;

/**
 * 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
 * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Main {
    /**
     * 遍历
     *
     * @param nums
     * @param target
     * @return int
     * @author wanglufei
     * @date 2022/8/18 3:43 PM
     */
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            //int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归
     *
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return int
     * @author wanglufei
     * @date 2022/8/18 3:43 PM
     */
    public int solutionSearch(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        //Arrays.binarySearch(nums, target, start, end);
        int mid = (start + end) >>> 1;

        if (target == nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            return solutionSearch(nums, target, mid + 1, end);
        } else {
            return solutionSearch(nums, target, start, mid - 1);
        }
    }
}
