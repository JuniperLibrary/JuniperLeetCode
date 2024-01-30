package com.uin.day;

import cn.hutool.json.JSONUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LC2808 {

  public static int minimumSeconds(List<Integer> nums) {
    Map<Integer, List<Integer>> maps = new HashMap<>();
    int n = nums.size();
    int res = n;

    for (int i = 0; i < n; i++) {
      // key为数组的中值 value为值的索引
      maps.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
    }

    log.info("maps:{}", JSONUtil.toJsonStr(maps));

    for (List<Integer> value : maps.values()) {
      int mx = value.get(0) - value.get(value.size() - 1);
      for (int i = 1; i < value.size(); i++) {
        mx = Math.max(mx, value.get(i) - value.get(i - 1));
      }
      res = Math.min(res, mx / 2);
    }
    return res;
  }

  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>();
    nums.add(1);
    nums.add(2);
    nums.add(1);
    nums.add(2);
    log.info("res:{}",minimumSeconds(nums));
  }
}
