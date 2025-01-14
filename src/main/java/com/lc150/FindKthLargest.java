package com.lc150;

import java.util.*;
import lombok.extern.slf4j.*;

@Slf4j
public class FindKthLargest {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int num : nums) {
      priorityQueue.add(num);
      if (priorityQueue.size()>k){
        priorityQueue.poll();
      }
    }
    return priorityQueue.peek();
  }

  public static void main(String[] args) {
    int kthLargest = new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    log.info("数组中的第K个最大元素:{}",kthLargest);
  }
}
