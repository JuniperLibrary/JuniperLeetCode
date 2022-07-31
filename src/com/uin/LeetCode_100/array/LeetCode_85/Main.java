package com.uin.LeetCode_100.array.LeetCode_85;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] grid = new int[rows][cols];
        int max = 0;
        buildHistogram(matrix, grid);
        for (int i = 0; i < rows; i++) {
            max = Math.max(max, maxRectangle(grid, i));
        }
        return max;
    }


    private void buildHistogram(char[][] matrix, int[][] grid) {
        for (int j = 0; j < matrix[0].length; j++) {
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                grid[i][j] = matrix[i][j] == '1' ? grid[i - 1][j] + 1 : 0;
            }
        }
    }

    private int maxRectangle(int[][] grid, int bottom) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int currentIndex = 0;
        while (currentIndex < grid[bottom].length) {
            while (stack.peek() != -1 && grid[bottom][currentIndex] <= grid[bottom][stack.peek()]) {
                max = Math.max(max, grid[bottom][stack.pop()] * (currentIndex - stack.peek() - 1));
            }
            stack.push(currentIndex++);
        }

        while (stack.peek() != -1) {
            max = Math.max(max, grid[bottom][stack.pop()] * (grid[bottom].length - stack.peek() - 1));
        }
        return max;
    }
}
