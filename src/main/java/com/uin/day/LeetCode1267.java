package main.java.com.uin.day;

public class LeetCode1267 {

  public int countServers(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    int[] rowServers = new int[rows];
    int[] colServers = new int[cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          rowServers[i]++;
          colServers[j]++;
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1 && (rowServers[i] > 1 || colServers[j] > 1)) {
         ans++;
        }
      }
    }
    return ans;
  }
}
