package com.lc150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

  List<Integer> nums;
  Map<Integer, Integer> indices;
  Random random;

  public RandomizedSet() {
    nums = new ArrayList<>();
    indices = new HashMap<>();
    random = new Random();
  }

  public boolean insert(int val) {
    if (indices.containsKey(val)){
      return false;
    }
    int index = nums.size();
    nums.add(val);
    indices.put(val,index);
    return true;
  }

  public boolean remove(int val) {
    if (!indices.containsKey(val)){
      return false;
    }
    // 获取待移除元素的索引
    int index = indices.get(val);
    // 获取列表最后一个元素
    int last = nums.get(nums.size() - 1);
    // 将待移除元素与最后一个元素交换位置
    nums.set(index,last);
    indices.put(last,index);
    nums.remove(nums.size() - 1);
    indices.remove(val);
    return true;
  }

  public int getRandom() {
    int randomIndex = random.nextInt(nums.size());
    return nums.get(randomIndex);
  }

  public static void main(String[] args) {
    RandomizedSet randomizedSet = new RandomizedSet();
    System.out.println(randomizedSet.insert(0));
    System.out.println(randomizedSet.remove(0));
    System.out.println(randomizedSet.insert(0));
    System.out.println(randomizedSet.getRandom());
  }
}
