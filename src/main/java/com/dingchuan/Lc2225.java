package com.dingchuan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Lc2225 {

  /**
   * 2225 找出输掉零场或一场比赛的玩家
   * <p>
   * 返回一个长度为2的列表 answer[0] 是所有没有输掉任何比赛的玩家列表 answer[1] 是所有恰好输掉 1 场比赛的玩家列表
   *
   * @param matches
   * @return
   */
  public List<List<Integer>> findWinners(int[][] matches) {
    HashMap<Integer, Integer> freq = new HashMap<>();
    for (int[] match : matches) {
      int winner = match[0];
      int losser = match[1];
      /**
       * 如果 winner 这个键不存在于哈希表 freq 中，则将键值对 (winner, 0) 添加到哈希表中。
       * 如果 winner 已经存在于哈希表中，则不执行任何操作。
       */
      freq.putIfAbsent(winner, 0);
      /**
       * 如果 loser 这个键不存在于哈希表中，则使用默认值 0（通过 freq.getOrDefault(loser, 0) 获取）加上 1，然后将新的值 (默认值+1) 与 loser 放入哈希表中。
       * 如果 loser 已经存在于哈希表中，则取出当前的值并加 1，然后更新 loser 对应的值为加 1 后的结果。
       */
      freq.put(losser, freq.getOrDefault(losser, 0) + 1);
    }
    ArrayList<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < 2; ++i) {
      ans.add(new ArrayList<Integer>());
    }
    for (Entry<Integer, Integer> integerIntegerEntry : freq.entrySet()) {
      int ket = integerIntegerEntry.getKey();
      int value = integerIntegerEntry.getValue();
      if (value < 2) {
        ans.get(value).add(ket);
      }
    }
    Collections.sort(ans.get(0));
    Collections.sort(ans.get(1));
    return ans;
  }
}
