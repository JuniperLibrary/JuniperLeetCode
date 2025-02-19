package com.dingchuan;

import java.util.*;

public class MaxDistance {

  public int maxDistance1(List<List<Integer>> arrays) {
    int res = 0, n = arrays.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < arrays.get(i).size(); j++) {
        for (int k = i + 1; k < n; k++) {
          for (int l = 0; l < arrays.get(k).size(); l++) {
            res = Math.max(res, Math.abs(arrays.get(i).get(j) - arrays.get(k).get(l)));
          }
        }
      }
    }
    return res;
  }

  public int maxDistance(List<List<Integer>> arrays) {
    List<Integer> array1, array2;
    int res = 0;
    int n = arrays.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        array1 = arrays.get(i);
        array2 = arrays.get(j);
        res = Math.max(res, Math.abs(array1.get(0) - array2.get(array2.size() - 1)));
        res = Math.max(res, Math.abs(array2.get(0) - array1.get(array1.size() - 1)));
      }
    }
    return res;
  }
}
