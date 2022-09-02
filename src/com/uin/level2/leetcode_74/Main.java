package com.uin.level2.leetcode_74;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * - 每行中的整数从左到右按升序排列。
 * - 每行的第一个整数大于前一行的最后一个整数。
 */
public class Main {
    /**
     * 二分
     *
     * @param matrix
     * @param target
     * @return boolean
     * @author wanglufei
     * @date 2022/9/2 8:57 AM
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 坐标轴法
     *
     * @param matrix
     * @param target
     * @return boolean
     * @author wanglufei
     * @date 2022/9/2 8:57 AM
     */
    public boolean helper(int[][] matrix, int target) {
        int rows = matrix.length - 1, columns = 0;

        while (rows >= 0 && columns < matrix[0].length) {
            int num = matrix[rows][columns];
            if (num == target) {
                return true;
            } else if (num > target) {
                rows--;
            } else {
                columns++;
            }
        }
        return false;
    }
}
