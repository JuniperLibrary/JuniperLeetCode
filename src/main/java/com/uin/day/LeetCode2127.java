package com.uin.day;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LeetCode2127 {

  public static void main(String[] args) {
    log.info("参加会议最多的员工数:{}", maximumInvitations(new int[]{2, 2, 1, 2}));
  }

  /**
   * 2127 参加会议最多的员工数
   */
  public static int maximumInvitations(int[] favorite) {
    // 员工编号从0到n-1。每位员工都有自己喜欢的员工。
    // 每位员工当且仅当他被安排在喜欢员工的傍边。
    // 每位员工喜欢的员工不会是他自己。

    // favorite[i] 表示第 i 位员工喜欢的员工
    // 返回参加会议的最多员工数目

    return Math.max(maxCycle(favorite), topologicalSort(favorite));
  }

  private static int topologicalSort(int[] fa) {
    int n = fa.length;
    int[] indeg = new int[n];
    int[] dist = new int[n];
    Arrays.fill(dist, 1);
    for (int v : fa) {
      indeg[v]++;
    }
    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      if (indeg[i] == 0) {
        q.offer(i);
      }
    }
    int ans = 0;
    while (!q.isEmpty()) {
      int i = q.pollFirst();
      dist[fa[i]] = Math.max(dist[fa[i]], dist[i] + 1);
      if (--indeg[fa[i]] == 0) {
        q.offer(fa[i]);
      }
    }
    for (int i = 0; i < n; ++i) {
      if (i == fa[fa[i]]) {
        ans += dist[i];
      }
    }
    return ans;
  }

  private static int maxCycle(int[] fa) {
    int n = fa.length;
    boolean[] vis = new boolean[n];
    int ans = 0;
    for (int i = 0; i < n; ++i) {
      if (vis[i]) {
        continue;
      }
      List<Integer> cycle = new ArrayList<>();
      int j = i;
      while (!vis[j]) {
        cycle.add(j);
        vis[j] = true;
        j = fa[j];
      }
      for (int k = 0; k < cycle.size(); ++k) {
        if (cycle.get(k) == j) {
          ans = Math.max(ans, cycle.size() - k);
        }
      }
    }
    return ans;
  }
}
