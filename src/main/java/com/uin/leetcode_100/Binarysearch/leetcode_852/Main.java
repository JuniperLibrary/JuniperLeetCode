package main.java.com.uin.leetcode_100.Binarysearch.leetcode_852;

/**
 * 852. 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i< arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    /**
     * 迭代
     *
     * @param arr
     * @return int
     * @author wanglufei
     * @date 2022/8/26 10:28 PM
     */
    public int solve(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 二分
     *
     * @param arr
     * @return int
     * @author wanglufei
     * @date 2022/8/26 10:29 PM
     */
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 1, right = arr.length - 2, ans = 0;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 二分
     *
     * @param arr
     * @return int
     * @author wanglufei
     * @date 2022/8/26 10:29 PM
     */
    public int helper(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < arr[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left < right ? right : left;
    }
}
