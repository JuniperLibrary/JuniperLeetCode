package com.uin.leetcode_100.linkedlist.leetcode_146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap实现LruCache,重点在重写removeEldestEntry 移除更老的元素
 *
 * @author dingchuan
 */
public class LruCacheLinkedHashMap extends LinkedHashMap<Integer, Integer> {

  private int capacity;

  /**
   * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
   *
   * @param eldest The least recently inserted entry in the map, or if this is an access-ordered
   *               map, the least recently accessed entry.  This is the entry that will be removed
   *               it this method returns {@code true}.  If the map was empty prior to the
   *               {@code put} or {@code putAll} invocation resulting in this invocation, this will
   *               be the entry that was just inserted; in other words, if the map contains a single
   *               entry, the eldest entry is also the newest.
   * @return
   */
  @Override
  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return size() > capacity;
  }

  public LruCacheLinkedHashMap(int capacity) {
    super(capacity, .75F, true);
    this.capacity = capacity;
  }

  public int get(int key) {
    return super.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    super.put(key, value);
  }
}
