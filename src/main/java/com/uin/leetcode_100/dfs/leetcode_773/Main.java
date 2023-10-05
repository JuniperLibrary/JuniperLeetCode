package main.java.com.uin.leetcode_100.dfs.leetcode_773;

/**
 * 733. 图像渲染
 * 有一幅以m x n的二维整数数组表示的图画image，其中image[i][j]表示该图画的像素值大小。
 * <p>
 * 你也被给予三个整数 sr , sc 和 newColor 。你应该从像素image[sr][sc]开始对图像进行 上色填充 。
 * <p>
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为newColor。
 * <p>
 * 最后返回 经过上色渲染后的图像。
 */

public class Main {
    int m, n;
    int initColor;
    int newColor;
    int[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        initColor = image[sr][sc];
        this.newColor = color;
        visited = new int[m][n];

        fill(image, sr, sc);
        return image;
    }

    public void fill(int[][] image, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1) return;

        visited[i][j] = 1;

        if (image[i][j] == initColor) {
            image[i][j] = newColor;
        } else {
            return;
        }

        fill(image, i + 1, j);
        fill(image, i - 1, j);
        fill(image, i, j + 1);
        fill(image, i, j - 1);
    }
}
