package com.dingchuan;

import java.util.*;

public class RangeFreqQuery {
  private Map<Integer, List<Integer>> occurrence;

  public RangeFreqQuery(int[] arr) {
    occurrence = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      occurrence.putIfAbsent(arr[i],new ArrayList<>());
      occurrence.get(arr[i]).add(i);
    }
  }

  public int query(int left,int right,int value){
    List<Integer> pos = occurrence.getOrDefault(value, new ArrayList<>());
    int l = lowerBound(pos,left);
    int r = upperBound(pos,right);
    return r -l;
  }

  private int upperBound(List<Integer> pos, int target) {
    int low = 0, high = pos.size() - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (pos.get(mid) <= target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  private int lowerBound(List<Integer> pos, int target) {
    int low = 0,high =pos.size()-1;
    while (low <= high){
      int mid = low + (high -low) /2;
      if(pos.get(mid) < target){
        low = mid +1;
      }else{
        high = mid -1;
      }
    }
    return low;
  }
}
