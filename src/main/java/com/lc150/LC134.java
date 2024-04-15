package com.lc150;

public class LC134 {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += gas[i] - cost[i];
    }

    if (sum < 0) {
      // 总油量小于总的消耗 无解
      return -1;
    }

    // 记录油箱中的油量
    int tank = 0;
    // 记录起点
    int start = 0;
    for (int i = 0; i < n; i++) {
      tank += gas[i] - cost[i];
      if (tank < 0) {
        // 无法从 start 到达 i+1
        start = i + 1;
        tank = 0;
      }
    }
    return start == n ? 0 : start;
  }

  public static void main(String[] args) {
    int[] gas = {1, 2, 3, 4, 5};
    int[] cost = {3, 4, 5, 1, 2};
    System.out.println(new LC134().canCompleteCircuit(gas, cost));
  }
}
