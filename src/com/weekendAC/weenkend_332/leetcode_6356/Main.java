package com.weekendAC.weenkend_332.leetcode_6356;

import java.util.HashMap;

public class Main {

  public int[][] substringXorQueries(String s, int[][] queries) {
    /**
     * 输入：s = "101101", queries = [[0,5],[1,2]]
     * 输出：[[0,2],[2,3]]
     * 解释：第一个查询，端点为 [0,2] 的子字符串为 "101" ，对应十进制数字 5 ，且 5 ^ 0 = 5 ，所以第一个查询的答案为 [0,2]。
     *      2^2+2^1+2^0=4+1=5
     *      第二个查询中，端点为 [2,3] 的子字符串为 "11" ，对应十进制数字 3 ，且 3 ^ 1 = 2 。所以第二个查询的答案为 [2,3] 。
     *      2^1+2^0=3
     */
    int n = queries.length;
    int[][] ans = new int[n][n];
    int i = 0;
    int ns = s.length();
    for (int[] query : queries) {
      i = query[0] ^ query[1];
      int j = 0, k = 1;
      //if (s.substring(j,k)=)
    }
    return ans;
  }

  public static int[][] solution(String s, int[][] queries) {
    HashMap<Integer, int[]> map = new HashMap<>();
    for (int i = 30; i > 0; i--) {
      for (int j = s.length() - i; j >= 0; j--) {
        map.put(Integer.valueOf(s.substring(j, i + j), 2), new int[]{j, i + j - 1});
      }
    }
    int[][] result = new int[queries.length][];
    for (int i = 0; i < queries.length; i++) {
      result[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], new int[]{-1, -1});
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(solution("101101", new int[][]{{0, 5}, {1, 2}}));
  }
}
