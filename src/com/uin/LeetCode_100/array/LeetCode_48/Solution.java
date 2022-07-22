package com.uin.LeetCode_100.array.LeetCode_48;

/**
 * LeetCode 46 旋转图像
 * 给定一个 n×n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wanglufei
 * @date 2022/7/22 4:36 PM
 */
public class Solution {
    public static void rotate(int[][] matrix) {
        //使用辅助数组
        int length = matrix.length;
        int[][] matrix_new = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix_new[j][length - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    public void solution2(int[][] nums) {
        int l = 0, r = 0, len = nums.length - 1;
        while (l < r) {
            for (int i = 0; i < r-1; i++) {
                int top = l, bottom = r;
                //临时变量
                int topleft = nums[top][l + i];
                //将左下角的元素向左上角
                nums[top][l + i] = nums[bottom - i][l];
                //将右下角移动到左下角
                nums[bottom-i][l] = nums[bottom][r-i];
                //右上角移动到右下角
                nums[bottom][r-i] = nums[top+i][r];
                //左上角移动到右上角
                nums[top+i][r] = topleft;
            }
            l+=l;
            r-=r;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(ints);
        }
    }
}
